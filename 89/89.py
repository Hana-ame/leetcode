class Solution:
    def grayCode(self, n: int) -> List[int]:
        nn = 1<<n
        res = []
        
        for i in range(nn):
            res.append( i^(i>>1) )
        
        return res