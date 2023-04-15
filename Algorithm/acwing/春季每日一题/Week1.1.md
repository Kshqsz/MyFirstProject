```c++
//二叉树遍历(中序遍历)
#include <bits/stdc++.h>
#define endl "\n"
using namespace std;
typedef pair<int,int> pii;
int k;
string str;
void dfs()
{
    if (str[k] == '#')
    {
        k ++ ;
        return;
    }
    char r = str[k ++ ];//根节点
    //cout << r << " ";前序遍历
    dfs();//左子树
    cout << r << " "; //中序遍历
    dfs();//右子树
    //cout << r << " ";后序遍历

}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0),cout.tie(0);
    cin >> str;
    dfs();
    return 0;
}
```

