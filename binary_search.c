#include <stdio.h>
#include <stdlib.h>

// Q@. Binary Search

int binary_search(int n, int arr[], int elem){
    int start = 0;
    int end = n-1;
    int mid = 0;

    while (start < end){
        mid = (start + end)/2;
        if (arr[mid] == elem) return mid;
        else if (arr[mid] > elem) end = mid -1;
        else start = mid +1;
    }
    return -1;
}
int main()
{
    int n,a = 0;
    printf("Enter size of the array\n");
    scanf("%d",&n);
    int arr[n];

    printf("Enter elements of the array in sorted order \n");
    for (int i = 0; i < n; i++){
        scanf("%d",&a);
        arr[i] = a;
    }

    int elem = 0;
    printf("Enter element to be searched  ");
    scanf("%d",&elem);
    int pos = binary_search(n, arr, elem);

    if (pos == -1 )printf("Element not found in the array");
    else printf("Element is present at position: %d", pos + 1);

    return 0;
}
