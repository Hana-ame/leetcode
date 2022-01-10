// 以前写的，啥玩意

#pragma once
#include<string>
#include<iostream>
using namespace std;
class Solution
{
public:
	string addBinary(string a, string b) {
		lena = 0; lenb = 0;	flag = 0;
		for (; a[lena]; lena++);
		for (; b[lenb]; lenb++);
		lena--; lenb--;

		while ((lena+1)&&(lenb+1))
		{
			switch ( a[lena] + b[lenb] - '0' - '0' + flag )
			{
			case 0:
				str = "0" + str ;	flag = 0; break;
			case 1:
				str = "1" + str ;	flag = 0; break;
			case 2:
				str = "0" + str ; flag = 1; break;
			case 3:
				str = "1" + str; flag = 1; break;
			default:break;
			}

			lena--;
			lenb--;
//			flag--;
			
		}
		
		while (lena!=-1) {
			switch (a[lena] - '0'  + flag)
			{
			case 0:
				str = "0" + str ;	flag = 0; break;
			case 1:
				str = "1" + str ; 	flag = 0; break;
			case 2:
				str = "0" + str ; flag = 1; break;
			case 3:
				str = "1" + str; flag = 1; break;
			default:break;
			}

			lena--;
//			lenb--;
//			flag--;
		}
		while (lenb!=-1){
			switch (b[lenb] - '0' + flag)
			{
			case 0:
				str = "0" + str ; 	flag = 0; break;
			case 1:
				str = "1" + str ;	flag = 0; break;
			case 2:
				str = "0" + str ; flag = 1; break;
			case 3:
				str = "1" + str; flag = 1; break;
			default:break;
			}

//			lena--;
			lenb--;
//			flag--;
		}
		if (flag == 1) { str = "1" + str; }
		return str;		
	}
private:
	int lena, lenb;
	int flag;
	string str;
};