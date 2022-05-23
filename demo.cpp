#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <ctype.h>

#define VexDateType char
#define StackElemType int
#define MaxVexDateLength 20   //最大课程名称长度
#define MaxClassNum 100      //最大课程数
#define MaxSemesterNum 12    //最大学期数
#define TextPath "D:\\DataStructure\\DSP\\教学计划编制\\input.txt"
#define TeachPlanPath "D:\\DataStructure\\DSP\\教学计划编制\\TeachingPlan.txt"

//邻接表表示法
//弧结点
typedef struct _ARCNODE ArcNode;
struct _ARCNODE {
	int AdjVex;                 //该弧所指向顶点位置
	ArcNode* Next;              //下一弧节点
};

//顶点结点
typedef struct _VEXNODE {
	VexDateType Date[MaxVexDateLength + 1];     //存储课程名称
	int Credit;                                //存储该课程学分
	ArcNode* FirstArc;                         //指向邻接节点

}VexNode;

//学期信息
typedef struct _INFO {
	int SemesterNum;          //总学期数
	int MaxCredit;            //每学期最大学分

}Info;

//图
typedef struct _ALGRAPH {
	//修改了一下
	VexNode Vertics[MaxClassNum];        //指向顶点节点
	int VexNum;              //课程总数
	int ArcNum;
	int* InDegree;           //指向入度数组
	Info* ExtraInfo;        //指向学期信息_INFO结构体

}ALGraph;

//利用栈辅助拓扑排序
typedef struct _STACK {
	StackElemType* Vertics;     //int型栈顶指针
	int tail, pos;

}Stack;

//栈的初始化
void InitStack(Stack* S) {
	S->Vertics = (StackElemType*)malloc(MaxClassNum * sizeof(StackElemType));
	if (!S->Vertics)
    {
        printf("开辟失败");
        exit(1);
    }
	S->pos = S->tail = 0;

}


//根据元素寻找顶点位置 默认元素为C1C2C3……顺序排布，C1位置为0，C2位置为1......
int Locate(char* ch) {
	return (2 == strlen(ch)) ? ch[1] - '1' : (ch[1] - '0') * 10 + ch[2] - '1';

}

//从文件读取信息
void Creat_ALGraph(ALGraph* G) {

	//初始化指针
	G->ExtraInfo = (Info*)malloc(sizeof(Info));

	//从文件读取信息
	FILE* fp = fopen(TextPath, "r");
	if (NULL == fp) {
		printf("文件路径有误");
		exit(EXIT_FAILURE);
	}

	//读学期总数 学分上限 课程总数(顶点数量)
	fscanf(fp, "%d%d%d", &G->ExtraInfo->SemesterNum, &G->ExtraInfo->MaxCredit, &G->VexNum);
	G->ArcNum = 0;

	if (G->VexNum > MaxClassNum) {
		printf("超出最大课程数%d,请更改数据\n", MaxClassNum);
		exit(EXIT_FAILURE);
	}
	if (G->ExtraInfo->SemesterNum > MaxSemesterNum) {
		printf("超出最大学期数%d,请更改数据\n", MaxSemesterNum);
		exit(EXIT_FAILURE);
	}

//	G->Vertics = (VexNode*)malloc(sizeof(VexNode) * G->VexNum);

	for (int i = 0; i < G->VexNum; i++)
		G->Vertics[i].FirstArc = NULL;

	//读取课程信息
	for (int i = 0; i < G->VexNum; i++) {

		//读取课程名称和学分
		fscanf(fp, "%s%d", G->Vertics[i].Date, &G->Vertics[i].Credit);

		//根据前序课程建立弧节点
		while ('\n' != fgetc(fp)) {              //以回车作为结束的标志
			char str[4];
			int pos;

			fscanf(fp, "%s", str);
			pos = Locate(str);

			//判断课程是不是没有
			if (pos < 0 || pos > G->VexNum) {
				printf("%s请输入正确的先决条件！\n", G->Vertics[i].Date);
				exit(EXIT_FAILURE);
			}


			//更新弧节点 注意是pos指向i的弧
			ArcNode* p = (ArcNode*)malloc(sizeof(ArcNode));
			p->AdjVex = i;
			p->Next = G->Vertics[pos].FirstArc;
			G->Vertics[pos].FirstArc = p;
			G->ArcNum++;
		}
	}
	fclose(fp);

	//更新入度数组
	G->InDegree = (int*)malloc(sizeof(int) * G->VexNum);
	memset(G->InDegree, 0, sizeof(int) * G->VexNum);     //首先初始化为0

	for (int i = 0; i < G->VexNum; i++) {
		for (ArcNode* p = G->Vertics[i].FirstArc; NULL != p; p = p->Next) {
			G->InDegree[p->AdjVex]++;
		}
	}
}

//各学期负担均匀
void UniformArrangement(ALGraph G, Stack S) {

	int TotalCreadit = 0;
	for (int i = 0; i < G.VexNum; i++)
		TotalCreadit += G.Vertics[i].Credit;
	int EachSemCredit = TotalCreadit / G.ExtraInfo->SemesterNum;
	FILE* fp = fopen(TeachPlanPath, "w");

    printf("各学期负担尽量均匀的教学编排结果如下\n");
	printf("结果已保存至TeachingPlan.txt文件中\n");
	for (int i = 0; i < G.ExtraInfo->SemesterNum; i++) {
		int tmp = 0;
		printf("\n第%d个学期的课程：", i + 1);
		fprintf(fp, "\n第%d个学期的课程：", i + 1);

		do {
			printf("%s ", G.Vertics[S.Vertics[S.pos]].Date);
			fprintf(fp, "%s ", G.Vertics[S.Vertics[S.pos]].Date);
			tmp += G.Vertics[S.Vertics[S.pos++]].Credit;
		} while (tmp < EachSemCredit && S.pos < G.VexNum);
		printf("\n(共%d学分) ", tmp);
		fprintf(fp, "\n(共%d学分)",tmp);
	}
	fclose(fp);
}

//集中在前几个学期
void CentralizedArrangement(ALGraph G) {

	FILE* fp = fopen(TeachPlanPath, "w");

	//重新更新入度数组
	memset(G.InDegree, 0, sizeof(int) * G.VexNum);

	for (int i = 0; i < G.VexNum; i++) {
		for (ArcNode* p = G.Vertics[i].FirstArc; NULL != p; p = p->Next) {
			G.InDegree[p->AdjVex]++;
		}
	}
	int count = 0;

	//记忆哪些课程是上学期学的
	int* Mark = (int*)malloc(sizeof(int) * G.VexNum);
	printf("课程尽可能集中在前几个学期的教学编排结果如下\n");
	printf("结果已保存至TeachingPlan.txt文件中\n");

	//外层循环为学期数
	for (int i = 0; i < G.ExtraInfo->SemesterNum; i++) {
		printf("\n第%d个学期的课程：", i + 1);
		fprintf(fp, "\n第%d个学期的课程：", i + 1);
		memset(Mark, 0, sizeof(int) * G.VexNum);

		for (int j = 0; j < G.VexNum; j++) {
			if (0 == G.InDegree[j]) {
				count++;
				Mark[j] = 1;
				G.InDegree[j]--;
				printf("%s ", G.Vertics[j].Date);
				fprintf(fp, "%s ", G.Vertics[j].Date);
			}
		}
		if (G.VexNum == count)
			break;
		//扫描Mark数组 通过标记为1的位置来更新入度结点
		for (int j = 0; j < G.VexNum; j++) {
			if (Mark[j]) {

				for (ArcNode* p = G.Vertics[j].FirstArc; NULL != p; p = p->Next)
					G.InDegree[p->AdjVex]--;
			}
		}
	}
	fclose(fp);
}

void shuru(ALGraph *G)
{
1	G->ExtraInfo = (Info*)malloc(sizeof(Info));
	printf("\t请输入学期数量:\n");
    scanf("%d", &G->ExtraInfo->SemesterNum);
    printf("\t请输入每学期学分上限:\n");
    scanf("%d", &G->ExtraInfo->MaxCredit);
    printf("\t请输入课程数量：\n");
    scanf("%d", &G->VexNum);
    printf("\t请依次输入课程的课程号、学分，以空格相间：\n");
   // printf(sizeof(G->Vertics));
    for (int i = 0; i < G->VexNum; i++)
    {
        printf("\t第%d个课程：", i+1);

        scanf("%s %d", G->Vertics[i].Date, &G->Vertics[i].Credit);
        G->Vertics[i].FirstArc=NULL;

        //Date是数组
		printf("%s %d",G->Vertics[i].Date, G->Vertics[i].Credit);
        printf("\n");
    }
    printf("\t输入边\n");
    for (int i = 0; i < G->VexNum; i++)
    {
        /* code */
        // typedef struct _ARCNODE ArcNode;
        printf("\t请输入课程的课程号:%d 的先修课程号(-1代表没有)：\n",i+1);
		ArcNode* arc;
        arc = (ArcNode*)malloc(sizeof(ArcNode));
        int pre_num;
        scanf("%d",&pre_num);
        if (pre_num==-1)
            continue;
		
        //在先修课程的表头插入当前课程
		arc->Next = NULL;
        arc->AdjVex = i;
        arc->Next = G->Vertics[pre_num].FirstArc;
        G->Vertics[pre_num].FirstArc = arc;
		printf("插入成功");
        //
    }


}

void Xiugai(ALGraph *G)
{
	int xiunum;
    char temke_num[5];
    printf("\t请输入要修改课程的数量：\n");
    scanf("%d", &xiunum);
    for (int i = 1; i <= xiunum; i++)
    {
        printf("\t请输入第%d个要修改课程的课程号：\n", i);
        scanf("%s", temke_num);
        int mb;
        for (int iq = 0; iq < G->VexNum; iq++)
        {
            if (strcmp(temke_num, G->Vertics[i].Date) == 0)
            {
                mb=iq;
                break;
                }
            }
            printf("请重新输入课程%s的课程号，学分和先修课程号,以空格相间：\n", temke_num);
            // TODO:
            //scanf("%s %d %s", G->Vertics[i].Date, &G->Vertics[i].Credit, &G->Vertics[i].FirstArc);
    }
}

void Xuanze(ALGraph G)
{
	Stack S, OutCome;
	InitStack(&S);
	InitStack(&OutCome);

	//寻找入度为0的顶点入栈
	for (int i = 0; i < G.VexNum; i++) {
		if (!G.InDegree[i]) {
			S.Vertics[S.tail++] = i;
		}
	}

	while (0 < S.tail) {

		int tmp = OutCome.Vertics[OutCome.tail++] = S.Vertics[--S.tail];
		for (ArcNode* p = G.Vertics[tmp].FirstArc; NULL != p; p = p->Next) {
			G.InDegree[p->AdjVex]--;
			if (0 == G.InDegree[p->AdjVex])
				S.Vertics[S.tail++] = p->AdjVex;
		}
	}


    if (OutCome.tail != G.VexNum) {
		printf("课程的先决条件有误！\n");
		exit(EXIT_FAILURE);
	}
	printf("                    ----------------------欢迎来到第九组教学计划编制系统----------------\n");
	printf("                    |                         0:各学期负担尽量均匀                     |\n");
	printf("                    |                         1:尽可能集中在前几个学期                 |\n");
	printf("                    |                         请输入你的选择：0-1                      |\n");
	printf("                    --------------------------------------------------------------------\n");

	int Command;
	scanf("%d", &Command);
	switch (Command)
	{
        case 0: UniformArrangement(G, OutCome); break;
        case 1: CentralizedArrangement(G); break;
        default: {
            printf("命令错误！");
            exit(EXIT_FAILURE);
        }
	}
}

void TopologicalSort(ALGraph G) {

//	Stack S, OutCome;
//	InitStack(&S);
//	InitStack(&OutCome);
//
//	//寻找入度为0的顶点入栈
//	for (int i = 0; i < G.VexNum; i++) {
//		if (!G.InDegree[i]) {
//			S.Vertics[S.tail++] = i;
//		}
//	}
//
//	while (0 < S.tail) {
//
//		int tmp = OutCome.Vertics[OutCome.tail++] = S.Vertics[--S.tail];
//		for (ArcNode* p = G.Vertics[tmp].FirstArc; NULL != p; p = p->Next) {
//			G.InDegree[p->AdjVex]--;
//			if (0 == G.InDegree[p->AdjVex])
//				S.Vertics[S.tail++] = p->AdjVex;
//		}
//	}
//
//
//if (OutCome.tail != G.VexNum) {
//		printf("课程的先决条件有误！\n");
//		exit(EXIT_FAILURE);
//	}
	printf("                    ----------------------欢迎来到第九组教学计划编制系统----------------\n");
	printf("                    |                         0:键盘读入课程                           |\n");
	printf("                    |                         1:从文件读入课程                         |\n");
	printf("                    |                         2:修改课程信息                           |\n");
	printf("                    |                         请输入你的选择：0-2                      |\n");
	printf("                    --------------------------------------------------------------------\n");
	int Command;
	scanf("%d", &Command);

	switch (Command) {
	case 0:
	shuru(&G);
	Xuanze(G);
	break;

	case 1:
	Creat_ALGraph(&G);
	Xuanze(G);
	break;

	case 2:
	Xiugai(&G);
	break;

	default: {
		printf("命令错误！");
		exit(EXIT_FAILURE);
	}
	}
}

int main(void) {

	ALGraph G;
	TopologicalSort(G);

	return 0;
}

