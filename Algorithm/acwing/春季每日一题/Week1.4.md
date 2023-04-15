```c++
#include <bits/stdc++.h>
#define endl "\n"
using namespace std;
typedef pair<int,int> pii;
const int N = 100010;
int n;
int l[N],r[N];
int f[N];

void solve()
{
    cin >> n;
    char num[20];
    for (int i = 0; i < n;i ++ )
    {
        cin >> num;
        l[i] = num[0] - '0' , r[i] = num[strlen(num) - 1] -'0';
    }
    int res = 0;
    for (int i = 0;i < n; i ++)
    {
        f[i] = i;
        for (int j = 0;j < i;j ++ )
        {
            if (r[j] == l[i])
            {
                f[i] = max(f[i],f[j] + 1);
            }
        }
        res = max(res,f[i]);
    }

    cout << n - res << endl; 
}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0),cout.tie(0);
    solve();    
    return 0;
}

```

