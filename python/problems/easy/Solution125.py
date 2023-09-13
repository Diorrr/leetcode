class Solution125:
    def __init__(self):
        pass

    def isPalindrome(self, s: str) -> bool:
        s = self.convert(s)

        for i in range(0, len(s) // 2):
            if s[i] != s[len(s) - 1 - i]:
                return False

        return True

    def convert(self, s: str) -> str:
        return ''.join([i for i in s.strip().lower() if i.isalnum()])