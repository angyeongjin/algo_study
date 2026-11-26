# 303. 범위 합계 쿼리 - 불변

- 플랫폼: LeetCode
- 문제: https://leetcode.com/problems/range-sum-query-immutable

## 문제 설명

정수 배열이 주어졌을 때 `nums`, 다음과 같은 유형의 여러 쿼리를 처리하세요.

1. 인덱스 사이( 및 <strong>포함)</strong> 의 요소들의 <strong>합을</strong> 계산합니다 .`nums``left``right` `left <= right`

해당 `NumArray`클래스를 구현하세요:

- `NumArray(int[] nums)`정수 배열로 객체를 초기화합니다 `nums`.
- `int sumRange(int left, int right)`인덱스 사이 (즉, 부터 <strong>까지 포함</strong> ) 의 요소들의 <strong>합을</strong> 반환합니다 .`nums``left``right` `nums[left] + nums[left + 1] + ... + nums[right]`

<strong>예시 1:</strong>

```
입력 
["NumArray", "sumRange", "sumRange", "sumRange"] 
[[[-2, 0, 3, -5, 2, -1]], [0, 2], [2, 5], [0, 5]] 출력 
[null, 1, -1, -3] 설명 
NumArray numArray = new NumArray([-2, 0, 3, -5, 2, -1]); 
numArray.sumRange(0, 2); // (-2) + 0 + 3 = 1 
반환 numArray.sumRange(2, 5); // 3 + (-5) + 2 + (-1) = -1 
반환 numArray.sumRange(0, 5); // (-2) + 0 + 3 + (-5) + 2 + (-1) = -3 반환
```

<strong>제약 조건:</strong>

- `1 <= nums.length <= 104`
- `-105 <= nums[i] <= 105`
- `0 <= left <= right < nums.length`
- 대부분의 경우 에 전화가 걸려올 것입니다 .`104``sumRange`

출처: LeetCode, https://leetcode.com/problems/range-sum-query-immutable
