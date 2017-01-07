package codeforces;

import java.util.*;

public class p743b{
static long pow(int i,long j){
long ans=1;
for(int k=0;k<j;k++)
ans=ans*i;

return ans;
}

public static void main(String args[]){
Scanner in=new Scanner(System.in);
long n=in.nextLong();
long k=in.nextLong();
long p=1;int x;
for(;n>0;){
p=pow(2,n-1);
if(k==p) {System.out.println(n);return;}
else if(k>p) {k= 2*p - k; n=n-1;}
else n=n-1;
}
}
}