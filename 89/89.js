/**
 * @param {number} n
 * @return {number[]}
 */
 var grayCode = function(n) {
    var nn = 1<<n;
    var res = new Array();
    
    for (i = 0; i < nn; i++){
        res[i] = i^(i>>1) ;
    }
    return res;
};