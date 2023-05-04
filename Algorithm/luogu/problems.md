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





## 倍增法

### P4155

![image-20230503142457835](problems.assets/image-20230503142457835.png)



```c++
#include <bits/stdc++.h>
#define endl "\n"

using namespace std;
typedef pair<int,int> pii;
const int N = 4e5 + 10;
int n, m;

struct warrior
{
    int id,L,R;

}w[N * 2];

bool cmp(warrior w1,warrior w2)
{
    return w1.L < w2.L;
}

int n2;
int go[N][20];
int res[N];

void init()
{
    int next = 1;
    for (int i = 1; i <= n2; i++)
    {
        while (next <= n2 && w[next].L <= w[i].R) next++;
        go[i][0] = next - 1; 
    }

    for (int i = 1; (1 << i) <= n; i++)
    {
        for (int s = 1; s <= n2; s++)
        {
            go[s][i] = go[go[s][i - 1]][i - 1];
        }
    }
}

void getans(int x)
{
    int len = w[x].L + m, cur = x, ans = 1;
    for (int i = __lg(N); i >= 0; i--)
    {
        int pos = go[cur][i];
        if (pos && w[pos].R < len)
        {
            ans += 1 << i;
            cur = pos;
        }
    }
    res[w[x].id] = ans + 1;
}
void solve()
{
    cin >> n >> m;
    for (int i = 1; i <= n; i++)
    {
        w[i].id = i;
        cin >> w[i].L >> w[i].R;
        if (w[i].R < w[i].L) w[i].R += m;
    }
    sort(w + 1, w + n + 1,cmp);

    n2 = n;
    for (int i = 1; i <= n; i++)
    {
        n2++;
        w[n2] = w[i], w[n2].L = w[i].L + m, w[n2].R = w[i].R + m;
    }
    init();
    for (int i = 1; i <= n; i++) getans(i);
    for (int i = 1; i <= n; i++) cout << res[i] << " ";
}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0),cout.tie(0);
    
    solve();    
    return 0;
}
```



## ST算法

### P2880

![image-20230503172257775](problems.assets/image-20230503172257775.png)

```c++
#include <bits/stdc++.h>
#define endl "\n"

using namespace std;
typedef pair<int,int> pii;
const int N = 50010;
int n,m;
int a[N],dp_max[N][22],dp_min[N][21];

int query(int l,int r)
{
    int k = __lg(r - l + 1);
    int x = max(dp_max[l][k], dp_max[r - (1 << k) + 1][k]);
    int y = min(dp_min[l][k], dp_min[r - (1 << k) + 1][k]);
    return x - y;
}
void init()
{
    for (int i = 1; i <= n; i++)
    {
        dp_max[i][0] = a[i];
        dp_min[i][0] = a[i];
    }

    int p = __lg(n);

    for (int k = 1; k <= p; k++)
    {
        for (int s = 1; s + (1 << k) <= n + 1; s++)
        {
            dp_max[s][k] = max(dp_max[s][k - 1], dp_max[s + (1 << (k - 1))][k - 1]);
            dp_min[s][k] = min(dp_min[s][k - 1], dp_min[s + (1 << (k - 1))][k - 1]);
        }
    }
}
void solve()
{
    cin >> n >> m;
    for (int i = 1; i <= n; i++) cin >> a[i];
    init();
    
    for (int i = 1; i <= m; i++)
    {
        int l, r;
        cin >> l >> r;
        cout << query(l,r) << endl;
    }
}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0),cout.tie(0);
    
    solve();    
    return 0;
}

```



## 排列与排序

### P1093

![image-20230503175858079](problems.assets/image-20230503175858079.png)

```C++
#include <bits/stdc++.h>
#define endl "\n"

using namespace std;
typedef pair<int,int> pii;
struct stu
{
    int id;
    int c,m,e;
    int sum;
}st[310];

bool cmp(stu a,stu b)
{
    if (a.sum > b.sum) return true;
    else if (a.sum < b.sum) return false;
    else
    {
        if (a.c > b.c) return true;
        else if (a.c < b.c) return false;
        else
        {
            if (a.id < b.id) return true;
            else return false;
        } 
    }
}

void solve()
{
    int n;
    cin >> n;
    for (int i = 1; i <= n; i++)
    {
        cin >> st[i].c >> st[i].m >> st[i].e;
        st[i].sum = st[i].c + st[i].m + st[i].e;
        st[i].id = i;
    }
    sort(st + 1, st + n + 1,cmp);
    for (int i = 1; i <= 5; i++)
    {
        cout << st[i].id << " " << st[i].sum <<endl;
    }
}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0),cout.tie(0);
    
    solve();    
    return 0;
}
```



# 搜索

## DFS

### P1019

![image-20230504170925418](problems.assets/image-20230504170925418.png)





```c++
#include <bits/stdc++.h>
#define endl "\n"

using namespace std;
typedef pair<int,int> pii;
const int N = 30;
int n, ans;
string s[N];
int use[N];

int check(string str1,string str2)
{
    int n1 = str1.size();
    int n2 = str2.size();
    for (int i = 1; i < min(n1, n2); i++)
    {
        int flag = 1;
        for (int j = 0; j < i; j++)
        {
            if (str1[n1 - i + j] != str2[j]) flag = 0;
        }
        if (flag) return i;
    }
    return 0;
}
void dfs(string str,int len)
{
    ans = max(ans, len);
    for (int i = 0; i < n; i++)
    {
        if (use[i] >= 2) continue;
        int c = check(str,s[i]);
        if (c > 0)
        {
            use[i]++;
            dfs(s[i], len + s[i].size() - c);
            use[i]--;
        }
    }
}
void solve()
{
    cin >> n;
    for (int i = 0; i <= n; i++) cin >> s[i];
    dfs(' '+ s[n],1);
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

### P5194

![image-20230504181942837](problems.assets/image-20230504181942837.png)





```c++
#include <bits/stdc++.h>
#define endl "\n"

using namespace std;
typedef pair<int,int> pii;
const int N = 55;
long long a[N], sum[N];
long long n, c, ans;

void dfs(int cur, long long res)
{
    if (res > c) return;
    if (res + sum[cur - 1] <= c)
    {
        ans = max(ans, res + sum[cur - 1]);
        return;
    }
    ans = max(ans, res);
    for (int i = 1; i <= cur - 1; i++) dfs(i, res + a[i]);
}
void solve()
{
    cin >> n >> c;

    for (int i = 1; i <= n; i++) cin >> a[i];
    for (int i = 1; i <= n; i++) sum[i] = sum[i - 1] + a[i];
    dfs(n + 1,0);
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



### P1378

![image-20230504195203889](problems.assets/image-20230504195203889.png)



```C++
#include <bits/stdc++.h>
#define endl "\n"

using namespace std;
typedef pair<int,int> pii;
const int N = 10;
const double PI = acos(-1);
int st[N];
double x[N], y[N], r[N], xa, ya, xb, yb, ans;
int n;

double cal(int i)
{
    double x1 = min(abs(x[i] - xa), abs(x[i] - xb));
    double y1 = min(abs(y[i] - ya), abs(y[i] - yb));
    double ans_r = min(x1, y1);

    for (int j = 1; j <= n; j++)
    {
        if (i != j && st[j])
        {
            double d = sqrt((x[i] - x[j]) * (x[i] - x[j]) + (y[i] - y[j]) * (y[i] - y[j]));
            ans_r = min(ans_r, max(d - r[j], 0.0));
        }

    }
    return ans_r;
}
void dfs(int u, double sum)
{
    if (u > n)
    {
        ans = max(ans, sum);
        return;
    }
    for (int i = 1; i <= n; i++)
    {
        if (!st[i])
        {
            r[i] = cal(i);
            st[i] = 1;
            dfs(u + 1, sum + r[i] * r[i] * PI);
            st[i] = 0;
        }
    }
}
void solve()
{
    cin >> n;
    cin >> xa >> ya >> xb >> yb;
    int area = abs(xa - xb) * abs(ya - yb);
    for (int i = 1; i <= n; i++)
    {
        cin >> x[i] >> y[i];
    }

    dfs(1, 0);

    cout << fixed << setprecision(0) << double (area) - ans << endl;
}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0),cout.tie(0);
    
    solve();    
    return 0;
}
```
