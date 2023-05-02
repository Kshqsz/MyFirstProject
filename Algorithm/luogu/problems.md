# 二分

## P1824

![image-20230502102334704](problems.assets/image-20230502102334704.png)

```C++
#include <bits/stdc++.h>
#define endl "\n"

using namespace std;
typedef pair<int,int> pii;
const int N = 1e5 + 10;
int n,c,x[N],ans;

bool check(int mid)
{
    int cnt = 1, p = 0;
    for (int i = 1; i < n; i++)
    {
        if (x[i] - x[p] >= mid)
        {
            cnt++;
            p = i;
        }
    }
    if (cnt >= c) return true;
    else return false;
}
void solve()
{
    cin >> n >> c;
    for (int i = 0; i < n; i++) cin >> x[i];
    sort(x,x + n);

    int l = 0, r = x[n - 1] - x[0];
    while (l < r)
    {
        int mid = (l + r) >> 1;
        if (check(mid))
        {
            ans = mid;
            l = mid + 1;
        }
        else r = mid;
    }
    cout << ans << endl;

}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0),cout.tie(0);
    
    solve();    
    return 0;
}
```



