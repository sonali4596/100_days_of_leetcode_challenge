//2125. Number of Laser Beams in a Bank
//T.c o(m*n)
//s.c o(1)
class Solution {
    public int numberOfBeams(String[] bank) {
        long beams=0;
        long prevd=0;
        long currd=0;
        prevd = bank[0].chars().filter(c -> c == '1').count();
        for(int i=1;i<bank.length;i++)
        {
            currd=bank[i].chars().filter(c->c=='1').count();
            if(currd!=0 &&prevd!=0)
                beams+=currd*prevd;
            if(currd!=0)prevd=currd;
        }
        return (int)beams;
    }
}
