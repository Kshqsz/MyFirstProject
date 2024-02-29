package 数据结构.第四章;

interface Istring {
    public void clear();
    public boolean empty();
    public int size();
    public char charat(int idx);
    public Istring substr(int begin, int end);
    public Istring insert(int to, Istring str);
    public Istring erase(int begin, int end);
    public Istring concat(Istring str);
    public int BF(Istring t, int strat);
}

public class SeqString {
    public static void main(String[] args) {
        string str = new string("ababcab");
        string str1 = new string("abc");
        int x = str.BF(str1, 0);
        System.out.print(x + "\n");
    }
}

class string implements Istring {
    char [] strvalue;
    int curlen;
    public string() {
        strvalue = new char[0];
        curlen = 0;
    }
    public char charat (int idx) {
        return strvalue[idx];
    }
    public string(String str) {
        char [] tempchararray = str.toCharArray();
        strvalue = tempchararray;
        curlen = tempchararray.length;
    }
    public string(char []value) {
        this.strvalue = new char [value.length];
        for (int i = 0; i < value.length; i++) {
            this.strvalue[i] = value[i];
        }
        curlen = value.length;
    }
    public void clear() {
        this.curlen = 0;
    }
    public boolean empty() {
        return curlen == 0;
    }
    public int size() {
        return curlen;
    }
    public Istring erase(int begin, int end) {
        for (int i = 0; i < curlen - end; i++) {
            strvalue[begin + i] = strvalue[end + i];
        }
        curlen = curlen - (end - begin);
        return this;
    }
    public Istring substr(int begin, int end) {
        if (begin == 0 && end == 0) {
            return this;
        } else {
            char[] buffer = new char[end - begin];
            for (int i = 0; i < buffer.length; i++) {
                buffer[i] = this.strvalue[i + begin];
            }
            return new string(buffer);
        }
    }
    public Istring insert(int offset, Istring str) {
        int len = str.size();
        int newCount = this.curlen + len;
        for (int i = this.curlen - 1; i >= offset; i--) {
            strvalue[len + i] = strvalue[i];
        }
        for (int i = 0; i < len; i++) {
            strvalue[offset + i] = str.charat(i);
        }
        this.curlen = newCount;
        return this;
    }
    public Istring concat(Istring str) {
        return insert(curlen, str);
    }
    public int BF(Istring t, int start) {
        int slen, tlen, i = start, j = 0;
        slen = this.size();
        tlen = t.size();
        while (i < slen && j < tlen) {
            if (this.charat(i) == t.charat(j)) {
                i++;
                j++;
            } else {
                i = i - j + 1;
                j = 0;
            }
            if (j >= t.size()) {
                return i - tlen;
            }
        }
        return -1;
    }
}


