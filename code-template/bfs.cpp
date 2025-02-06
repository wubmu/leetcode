#include <iostream>
#include <vector>
#include <queue>

using namespace std;
class TreeNode{
public:
    int val;
    TreeNode* left;
    TreeNode* right;
    TreeNode(int x): val(x), left(nullptr), right(nullptr){};
};

void bfs(TreeNode* root){
    if (root == nullptr){
        return;
    }

    queue<TreeNode*> q;
    q.push(root);
    // 记录当前层数
    int depth = 1;
    while(!q.empty()){
        
        // 记录当前层的个数
        int sz = q.size();
        for(int i = 0; i < sz; i++){
            // 取出头元素
            TreeNode* cur = q.front();
            q.pop();

            cout << "depth = " << depth << ", val = " << cur->val << endl;

            // 子节点加入到队列中
            if (cur->left != nullptr){
                q.push(cur->left);
            }
            if (cur->right != nullptr){
                q.push(cur->right);
            }
        }

        // 当前层遍历结束，进入下一层
        depth++;
    }

}

int main(int argc, char const *argv[])
{
    // 创建一个简单的二叉树
    //       1
    //      / \
    //     2   3
    //    /|   |\
    //   4 5   6 7

    TreeNode* root = new TreeNode(1);
    root->left = new TreeNode(2);
    root->right = new TreeNode(3);
    root->left->left = new TreeNode(4);
    root->left->right = new TreeNode(5);
    root->right->left = new TreeNode(6);
    root->right->right = new TreeNode(7);

    // 调用 bfs 函数
    bfs(root);

    return 0;

}
