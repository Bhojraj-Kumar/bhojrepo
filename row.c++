	int arr[m][n];
	for(int i=0;i<m;i++)
	{
		for(int j=0;j<n;j++)
		{
			scanf("%d",&arr[i][j]);
		}
	}
	printf("Original Matrix : \n");
	for(int i=0;i<m;i++)
	{
		for(int j=0;j<n;j++)
		{
		printf("%d ",arr[i][j]);
		}
		printf("\n");
	}
	int r1,r2;
	printf("Enter the row numbers which are to be interchanged : ");
	scanf("%d %d",&r1,&r2);
	r1=r1-1;
	r2=r2-1;
	for(int i=0;i<n;i++)
	{
		int temp=arr[r1][i];
		arr[r1][i]=arr[r2][i];
		arr[r2][i]=temp;
	}
	printf("New Matrix : \n");
	for(int i=0;i<m;i++)
	{
		for(int j=0;j<n;j++)
		{
		printf("%d ",arr[i][j]);
		}
		printf("\n");
	}
	return 0;
}
