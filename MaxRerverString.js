// 暴力
function solutionNormal() {
  const str = 'aacbabaac';
  let i = 0,
    len = str.length - 1,
    left = 0,
    right = len,
    start = 0,
    end = 0,
    arr = [];
    output = "";
  if (str.length == 1) return str;  
  while (i < len) {
    arr[i] = 0;
    left = i;
    right = len;
    start = i;
    end = len;
    if (output.length >= len + 1 - i) return output;
    while (left < right) {
      if (str[left] === str[right]) {
        // if (start < left) start = left;
        // if (end > right || end === 0) end = right;
        left++;
        right--;
      } else {
        start = left = i;
        right = --end;
        
        
      }
    }
    if (output.length <= end + 1 - start) output = str.substring(start, end + 1);
    i++;
  }    
}


function solutionDP(str) {
  const len = str.length
  let arr = new Array(len).fill(false)
  let dp = new Array(len).fill(arr)
  let maxLen = 0;
  let begin = 0;
  if (len < 2) return str;
  // for(let i = 0; i < len; i++) dp[i][i] = true
  // console.log(dp)

  
  for (let j = 1; j < len; j++) {
    for (let i = 0; i < j; i++) {
      if (str[i] === str[j]) {
        // console.log(, dp[i])
        if (j - i < 3) {
          console.log(i, j)
          dp[i][j] = true;
        }
        else {
          console.log(i, j, dp[i+1][j-1])
          dp[i][j] = dp[i+1][j-1]
        }
      }
      
      if (dp[i][j] && j - i > maxLen) {
        // console.log(i, j)
        maxLen = j - i + 1
        begin = i
      }
    }
  }

  // console.log(dp)
  
  return [maxLen, begin]
}

console.log(solutionDP('aacababaac'))