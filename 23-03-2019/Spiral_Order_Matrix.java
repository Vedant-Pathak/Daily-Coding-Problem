public class Spiral_Order_Matrix {
    // DO NOT MODIFY THE LIST
    public ArrayList<Integer> spiralOrder(final List<ArrayList<Integer>> A) 
    {
        int m = A.size();
        if(m == 0)
            return new ArrayList<Integer>();
        int n = A.get(0).size();
        int row,col,layer;
        row = col = layer = 0;
        ArrayList<Integer> ans = new ArrayList<Integer>();
        int dir = 0;
        ans.add(A.get(0).get(0));
        for(int step = 1; step < m*n; step++)
        {    
            switch(dir)
            {
                case 0:
                    if(col == n - layer - 1)
                    {
                        dir = 1;
                        row++;
                    }
                    else
                        col++;
                    break;
                case 1:
                    if(row == m - layer - 1)
                    {
                        dir = 2;
                        col--;
                    }
                    else
                        row++;
                    break;
                case 2:
                    if(col == layer)
                    {
                        dir = 3;
                        row--;
                    }
                    else
                        col--;
                    break;
                case 3:
                    if(row == layer + 1)
                    {
                        layer++;
                        col++;
                        dir = 0;
                    }
                    else
                        row--;
            }
        ans.add(A.get(row).get(col));
        }
        //System.out.println(ans);
        return ans;
    }
}
