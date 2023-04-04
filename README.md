# Lab8

Benjamin: Print, add and rotate methods

Will: tree, testing

Nikki: balance

Anusha: height

//nikkis method
public int getbalance(Node n)
	{
		int temp;
		if(n!=null)
		{
			temp=1+getbalance(n.right)-getbalance(n.left);
			n.balance=temp;
			return temp;
		}
		return 0;
	}
