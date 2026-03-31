import unittest
from scanner import tokenize

class TestScanner(unittest.TestCase):

    def test_codigo(self):
        codigo = "x = 10"
        tokens = tokenize(codigo)
        self.assertEqual(tokens, [('ID', 'x'), ('OP', '='), ('NUM', '10')])

if __name__ == '__main__':
    unittest.main()