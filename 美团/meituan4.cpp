#include <iostream>
#include <string>
#include <vector>
using namespace std;

class Solution {
public:
    bool isSubsequence(string s, string t) {
        int n = s.length(), m = t.length();
        int i = 0, j = 0;
        while (i < n && j < m) {
            if (s[i] == t[j]) {
                i++;
            }
            j++;
        }
        return i == n;
    }

    void printAllSub(string str,int i, string res){
        if(i == str.length()){
            cout << "\n" << res << endl;
            return;
        }else{
            printAllSub(str,i + 1, res);
            printAllSub(str, i+ 1, res+str[i]);
        }
    }

};

int main() {

    string s1,s2;
    Solution().printAllSub("abab",0,"");
    
    vector<int> arr = {1, 2, 3, 4};

    for (let i = 1; i <= arr.length; i++) {
    let a = [];
    for (let j = 0; j < arr.length; j++) {
        a.push(arr[j]);
        if (a.length === i) {
        break;
        }
    }
    cout << "You inputed chars are:\n " << a << endl;
    }


    // getline(cin,s1);
    // getline(cin,s2);
    // s1 = "abc";
    // s2 = "ahbgdc";
    // cout << "You inputed chars are: " << Solution().isSubsequence(s1,s2) << endl;
    // //return 0;
    // system("pause");
}

