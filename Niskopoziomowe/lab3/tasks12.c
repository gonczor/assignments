#include "tasks.h"

void task12()
{
    int arr1[] = {1, 3, 5, 7};
    const int arr1_size = sizeof(arr1)/sizeof(int);
    int arr2[] = {2, 3, 6, 9, 10};
    const int arr2_size = sizeof(arr2)/sizeof(int);
    int arr_sorted[arr1_size + arr2_size];

    int i, j, k;
    i = j = k = 0;

    while(i < arr1_size && j < arr2_size)
    {
        if(arr1[i] < arr2[j])
            arr_sorted[k++] = arr1[i++];
        else
            arr_sorted[k++] = arr2[j++];
    }
    while(i < arr1_size)
        arr_sorted[k++] = arr1[i++];
    while(j < arr2_size)
        arr_sorted[k++] = arr2[j++];

    for(k = 0; k < sizeof(arr_sorted)/sizeof(int); k++)
        printf("%d\n", arr_sorted[k]);
}
