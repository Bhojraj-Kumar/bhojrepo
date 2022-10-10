import java.util.*;
import java.io.*;
public class Tic_Tac_Toe
{
    //1 in arr define player 1
    //2 in arr define player 2
    static int choice=-1;
    static boolean check_game_end(int arr[])
    {
        boolean val=false;
        if(check_win(arr)==1 || check_win(arr)==-1)
        val=true;
        else if(check_win(arr)==0)
        {
            int count=0;
           for(int i=0;i<9;i++)
           if(arr[i]==0)
           count++;
           if(count==0)
           val=true;
        }
        return val;
    }
    
    static int check_win(int arr[])
    {
        if((arr[0]==1 && arr[1]== 1 && arr[2]== 1)||(arr[3]==1 && arr[4]== 1 && arr[5]== 1)||
            (arr[6]==1 && arr[7]== 1 && arr[8]== 1)||(arr[0]==1 && arr[3]== 1 && arr[6]== 1)||
            (arr[1]==1 && arr[4]== 1 && arr[7]== 1)||(arr[2]==1 && arr[5]== 1 && arr[8]== 1)||
            (arr[0]==1 && arr[4]== 1 && arr[8]== 1)|| (arr[2]==1 && arr[4]== 1 && arr[6]== 1))
        {
            return 1;
        }
        else if((arr[0]==2 && arr[1]== 2 && arr[2]== 2)||(arr[3]==2 && arr[4]== 2 && arr[5]== 2)||
            (arr[6]==2 && arr[7]== 2 && arr[8]== 2)||(arr[0]==2 && arr[3]== 2 && arr[6]== 2)||
            (arr[1]==2 && arr[4]== 2 && arr[7]== 2)||(arr[2]==2 && arr[5]== 2 && arr[8]== 2)||
            (arr[0]==2 && arr[4]== 2 && arr[8]== 2)|| (arr[2]==2 && arr[4]== 2 && arr[6]== 2))
            {
                return -1;
            }
        else
            return 0;
    }
    static int score(int arr[])
    {
        if(check_win(arr)==1)
        return 10;
        else if(check_win(arr)==-1)
        return -10;
        else
        return 0;
    }
    static int solve_tictactoe(int arr[],int depth,boolean chance)
    {
        if(check_game_end(arr))
        {
            return score(arr);
        }
       
            int pointmax=-20;
            int pointmin=20;
            
            int val=0;
             if(chance)
            {
                for(int i=0;i<9;i++)
                {
                    if(arr[i]==0)
                    {
                   
                        arr[i]=1;
                        int temp=solve_tictactoe(arr,depth+1,false);
                        if(temp>pointmax)
                        {
                            pointmax=temp;
                            choice=i;
                        }
                        arr[i]=0;
                    }
                }
                return pointmax;
            }
            else
            {
                for(int i=0;i<9;i++)
                {
                    if(arr[i]==0)
                    {
                        arr[i]=2;
                        int temp=solve_tictactoe(arr,depth+1,true);
                        if(temp<pointmin)
                        {
                            pointmin=temp;
                            choice=i;
                        }
                        arr[i]=0;
                    }
                }
                return pointmin;
            
        }
    }
    static int best_move(int arr[])
    {
        int max=-20;
        int pos=-1;
        for(int i=0;i<9;i++)
        {
            if(arr[i]==0){
                arr[i]=1;
           int temp= solve_tictactoe(arr,0,false);
           if(temp>max)
           {
               max=temp;
               pos=i;
        }
        arr[i]=0;
    }
        }
        return pos;
    }
    public static void main(String[] args)throws IOException
    {
        BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
        System.out.println("1 2 3");
        System.out.println("4 5 6");
        System.out.println("7 8 9");
        int arr[]=new int[9];
        for(int i=0;i<9;i++)
        arr[i]=0;
        while(!check_game_end(arr))
        {
        System.out.println("Enter your Choice");
        int n=Integer.parseInt(br.readLine());
        arr[n-1]=2;
        //int get = solve_tictactoe(arr,0,false);
        if(check_game_end(arr))
        break;
       // System.out.println("best_move"+best_move(arr));
        //System.out.println("choice"+choice);
        arr[best_move(arr)]=1;
        for(int i=0;i<3;i++)
        {
            for(int j=0;j<3;j++)
            {
                System.out.print(arr[3*i + j]+" ");
            }
            System.out.println();
        }
        }
        if(check_win(arr)==1)
        System.out.println("System win");
        else if(check_win(arr)==-1)
        System.out.println("User win");
        else
        System.out.println("Game Draw");
        
    }
}
