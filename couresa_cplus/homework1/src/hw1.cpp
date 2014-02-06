/*  Convert this program to C++
*   change to C++ io
*   change to one line comments
*   change defines of constants to const
*   change array to vector<>
*   inline any short function
*/

#include <iostream>
#include <vector>

using namespace std;
const int N=40;

inline int vectorSum(vector<int>& v)
{
	int sum =0;
	for(int i=0;i<v.size();++i)
		sum += v.at(i);
	return sum;
}





int main()
{
   vector<int> data;

   for(int i = 0; i < N; ++i)
	   data.push_back(i);



   cout << "sum is " << vectorSum(data) << endl;
   return 0;
}
