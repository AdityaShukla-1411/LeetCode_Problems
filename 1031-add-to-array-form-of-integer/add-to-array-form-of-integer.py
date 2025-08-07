from typing import List

class Solution:
    def addToArrayForm(self, num: List[int], k: int) -> List[int]:
        i = len(num) - 1
        carry = 0
        result = []

        while i >= 0 or k > 0 or carry > 0:
            n = num[i] if i >= 0 else 0
            digit = k % 10
            total = n + digit + carry
            result.append(total % 10)
            carry = total // 10
            k //= 10
            i -= 1

        return result[::-1]
