![image-20230419111138335](Week2.2.assets/image-20230419111138335.png)

```C++
#include <bits/stdc++.h>
#define endl "\n"

using namespace std;
typedef pair<int,int> pii;

bool cmp(int a,int b)
{
    return a > b;
}

void solve()
{
    vector<int> v1,v2;

    for (int i = 0; i < 10; i++)
    {
        int x;
        cin >> x;
        if (x&1) v1.push_back(x);
        else v2.push_back(x);
    }

    sort(v1.begin(),v1.end(),cmp);
    sort(v2.begin(),v2.end());

    for (auto it : v1) cout << it << " ";
    for (auto it : v2) cout << it << " ";

}
int main()
{
    ios::sync_with_stdio(false);
    cin.tie(0),cout.tie(0);
    
    solve();    
    return 0;
}
```

