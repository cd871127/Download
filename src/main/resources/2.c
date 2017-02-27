#include <stdio.h>

int lengthOfLongestSubstring(char* s);

int main()
{
	char *a="aab";
	
	printf("%d\n",lengthOfLongestSubstring(a));
	return 0;
}

int lengthOfLongestSubstring(char* s) {
	if(s==0||s[0]=='\0')
		return 0;
	if(s[1]=='\0')
		return 1;
    int max=1,i=0,j=0,tmp=1,m=1;
	int flag=0;
	while(s[i]!='\0')
	{
		m=j+1;
		if(s[m]=='\0')
			break;
		flag=1;
		int n=i;
		for(;n<=j;++n)
		{
			if(s[m]==s[n])
			{
				flag=0;
				break;
			}
		}
		
		if(flag)
		{
			++tmp;
			j=m;
		}
		else
		{	
			i=m;
			j=i+1;
			tmp=1;
		}
		if(max<tmp)
			max=tmp;
	}
    return max;
}
