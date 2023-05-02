# 二分

## 3122

```c++
#include <bits/stdc++.h>
#define endl "\n"

using namespace std;
typedef pair<int,int> pii;
const double PI = acos(-1.0);
const double eps = 1e-6;
const int N = 1e4 + 10;
double area[N];
int n, m;

bool check(double mid)
{
    int cnt = 0;
    for (int i = 0; i < n; i++)
    {
        cnt += (int) (area[i] / mid);
    }
    if (cnt >= m) return true;
    else return false;
}
void solve()
{
    cin >> n >> m;
    m++;
    double maxx = 0;
    for (int i = 0; i < n; i++)
    {
        int r;
        cin >> r;
        area[i] = PI * r * r;
        if (maxx < area[i]) maxx = area[i];
    }

    double l = 0, r = maxx;
    while (r - l > eps)
    {
        double mid = (l + r) / 2;
        if (check(mid))
        {
            l = mid;
        }
        else r = mid;
    }

    cout << fixed << setprecision(4) << l << endl;
}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0),cout.tie(0);
    int t;
    cin >> t;
    
    while (t--)
    {
        solve();
    }
    return 0;
}
```

