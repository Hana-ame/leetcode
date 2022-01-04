int bitwiseComplement(int n) {
        // int n1 = n+1;
        // if (n==0) return 1;
        int anchor = 1;
        while (anchor <= n){
            anchor <<= 1;
        }
        --anchor;
        return n ^ (anchor);
    }

int main(){
    int a = bitwiseComplement(1);
    a = bitwiseComplement(0);
    a = 1 ^ 1;
    return a;
}