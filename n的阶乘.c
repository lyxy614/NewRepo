#include <stdio.h>
//int main()
//{
//	int m = 1;
//	int n = 0;
//	scanf_s("%d", &n);
//	for (int i = 1; i <= n; i++)
//	{
//		m = m * (i + 1);
//
//	}
//	printf("m = %d\n", m);
//	return 0;
//}

//int main()
//{
//	int m = 1;
//	int n = 0;
//	int sum = 0;
//	scanf_s("%d", &n);
//	for (int i = 1; i <= n; i++)
//	{
//		m = m * i;
//		sum = sum + m;
//	}
//	printf("sum = %d\n", sum);
//	return 0;
//}

#include <stdio.h>
int main()
{
	int arr[100] = { 0 };
	for (int i = 0; i < 100; i++)
	{
		arr[i] = i + 1;
	}
	int k;
	scanf_s("%d", &k);
	int left = 0;
	int right = sizeof(arr) / sizeof(arr[0]) - 1;
	int i1 = 1;
	while (left <= right)
	{
		int mid = (left + right) / 2;
		if (arr[mid] < k)
			left = mid + 1;
		else if (arr[mid] > k)
			right = mid - 1;
		else
		{
			printf("找到了，下标是:%d\n", mid);
			printf("找了%d次\n", i1);
			break;
		}
		i1++;
	}
	if (left > right)
		printf("找不到\n");
	return 0;
}