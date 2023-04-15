```c++
#include <bits/stdc++.h>
#define endl "\n"
using namespace std;
typedef pair<int,pair<int,int>> pii;
int t,n;
int st[15];
struct 
{
    int t,d,l;
}v[15];

bool dfs(int u,int time)
{
    if (u==n) return true;
    for (int i=1;i<=n;i++)
    {
        if (!st[i])
        {
            int time2=max(time,v[i].t);
            if (time2>v[i].t + v[i].d) return false;
            time2+=v[i].l;
            st[i]=1;
            if (dfs(u+1,time2)) return true;
            st[i]=0;
        }
    }
    return false;
}
void solve()
{
    cin>>n;
    for (int i=1;i<=n;i++) cin>>v[i].t>>v[i].d>>v[i].l;
    for (int i=1;i<=n;i++) st[i]=0;
    int f = dfs(0,0);
    cout<<(f?"YES\n":"NO\n");
}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0),cout.tie(0);
    cin>>t;
    while (t--)
    {
        solve();
    }
    return 0;
}
```

