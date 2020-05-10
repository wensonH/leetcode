const str = 'aacbabaac';
let i = 0,
  len = str.length - 1,
  left = 0,
  right = len,
  start = 0,
  end = 0,
  arr = [];
while (i < len) {
  arr[i] = 0;
  left = i;
  right = len;
  start = i;
  end = len;
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
  console.log(str.substring(start, end + 1));
  i++;
}
console.log(str.substring(left, right));
