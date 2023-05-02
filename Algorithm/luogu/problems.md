# 基本算法

## 二分

### P1824

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



### P1419



![image-20230502125111484](problems.assets/image-20230502125111484.png)

```
#include <bits/stdc++.h>
#define endl "\n"

using namespace std;
typedef pair<int,int> pii;
const int N = 1e5 + 10;
const double eps = 1e-5;
double v[N];
double a[N];
int n,s,t;

bool check(double mid)
{
    deque<int> de;
    for (int i = 1; i <= n; i++)
    {
        a[i] = v[i] - mid;
        a[i] += a[i - 1];
    }
    for (int i = 1; i <= n; i++)
    {
        if (i >= s)
        {
            while (!de.empty() && a[i - s] < a[de.back()]) de.pop_back();
            de.push_back(i - s);
        }
        if (!de.empty())
        {
            if (de.front() < i - t) de.pop_front();
            if (a[i] - a[de.front()] >= 0) return true;
        }
    }
    return false;
}
void solve()
{
    cin >> n;
    cin >> s >> t;
    for (int i = 1; i <= n; i++)
    {
        cin >> v[i];
    }
    double l = -1e4 , r = 1e4;
    while (r - l > eps)
    {
        double mid = (r + l) / 2;
        if (check(mid)) l = mid;
        else r = mid;
    }
    cout << fixed << setprecision(3) << l << endl;
}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0),cout.tie(0);
    
    solve();    
    return 0;
}
```



### P1083

![image-20230502172738324](problems.assets/image-20230502172738324.png)



```C++
#include <bits/stdc++.h>
#define endl "\n"

using namespace std;
typedef pair<int,int> pii;
const int N = 1e6 + 10;
long long q[N],need[N],lef[N],rig[N],s[N],d[N];
long long n,m;



bool check(long long mid)
{
    memset(d,0,sizeof d);
    for (long long i = 1; i <= mid; i++)
    {
        d[lef[i]] += s[i];
        d[rig[i] + 1] -= s[i];
    }
    for (long long i = 1; i <= n; i++)
    {
        need[i] = need[i - 1] + d[i];
        if (need[i] > q[i]) return false;
    }
    return true;
}
void solve()
{
    cin >> n >> m;
    for (long long i = 1; i <= n; i++) cin >> q[i];
    for (long long i = 1; i <= m; i++) cin >> s[i] >> lef[i] >> rig[i];

    if (check(m))
    {
        cout << 0 << endl;
        return;
    }

    long long l = 1, r = m;
    while (l < r)
    {
        long long mid = l + r >> 1;
        if (check(mid)) l = mid + 1;
        else r = mid ;
    }

    cout << -1 << endl << l << endl;
}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0),cout.tie(0);
    
    solve();    
    return 0;
}
```







## 三分

### P3382





![image-20230502205109914](problems.assets/image-20230502205109914.png)

```c++
#include <bits/stdc++.h>
#define endl "\n"

using namespace std;
typedef pair<int,int> pii;
const int N = 15;
const double eps = 1e-7;
double q[N];
double n, l, r;


double f(double x)
{
    double s = 0;
    for (int i = n; i >= 0; i--) s = s * x + q[i];
    return s;
}
void solve()
{
    cin >> n >> l >> r;
    for (int i = n; i >= 0; i--) cin >> q[i];

    while (r - l > eps)
    {
        double k = (r - l) / 3;
        double mid1 = l + k , mid2 = r - k;
        if (f(mid1) > f(mid2)) r = mid2;
        else l = mid1;
    }
    
    cout << fixed << setprecision(5) << l << endl;


}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0),cout.tie(0);
    
    solve();    
    return 0;
}
```





### P3745



![image-20230502214402136](problems.assets/image-20230502214402136.png)

```
//只要有一门课没用结课 就有不愉快产生 所以其实是所有卷子改完的时候是一样的
#include <bits/stdc++.h>
#define endl "\n"

using namespace std;
typedef pair<int,int> pii;
const int N = 1e5 + 10;
long long n,m,t[N],b[N];
long long A,B,C,ans;
long long mi = 0x3f3f3f3f;


long long calc1(int p)
{
    long long x = 0, y = 0;
    for (int i = 1; i <= m; i++)
    {
        if (b[i] < p) x += p - b[i]; //可以被操作A推迟的天数(用来垫脚) 用来提前其他天数
        else y += b[i] - p; // 需要提前的天数
    }
    
    if (A < B) return A * min(x,y) + B *(y - min(x,y));
    else return B * y;
}

long long calc2(int p)
{
    long long sum = 0;
    for (int i = 1; i <= n; i++)
    {
        if (p > t[i]) sum += (p - t[i]) * C;
    }
    return sum;
}
void solve()
{
    cin >> A >> B >> C;
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
    {
        cin >> t[i];
        mi = min(mi,t[i]);
    }
    for (int i = 1; i <= m; i++) cin >> b[i];
    if (C >= 1e16)
    {
        cout << calc1(mi) << endl;
        return;
    }
    ans = 1e16;
    int l = 1, r = N;
    while (r - l > 2)
    {
        int mid1 = l + (r - l) / 3 ,mid2 = r - (r - l) / 3;
        long long c1 = calc1(mid1) + calc2(mid1);
        long long c2 = calc1(mid2) + calc2(mid2);
        if (c1 <= c2) r = mid2;
        else l = mid1;
    }
    
    for (int i = l; i <= r; i++)
    {
        long long x = calc1(i) + calc2(i);
        ans = min(x,ans); 
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



### P1883

![image-20230502225722110](problems.assets/image-20230502225722110.png)





```C++
#include <bits/stdc++.h>
#define endl "\n"

using namespace std;
typedef pair<int,int> pii;
const int N = 1e4 + 10;
const double eps = 1e-11;
int a[N],b[N],c[N];
int n;

double f(double x,int i)
{
    return x * x * a[i] + x * b[i] + c[i];
}
double check(double x)
{
    double ans = f(x,1);
    for (int i = 2; i <= n; i++)
    {
        ans = max(ans,f(x,i)); // F(x) 求的就是若干个f(x)最小值的最大值
    }
    return ans;
}
void solve()
{
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        cin >> a[i] >> b[i] >> c[i];
    }

    double l = 0, r = 1000, mid1 ,mid2;

    while (r - l > eps)
    {
        mid1 = l + (r - l) / 3;
        mid2 = r - (r - l) / 3;
        if (check(mid1) > check(mid2)) l = mid1;
        else r = mid2;
    }

    cout << fixed << setprecision(4) << check(l) << endl;

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

