package h564;

class Solution {
    public String nearestPalindromic(String n) {
        byte[] src = str2bytes(n);
        byte[] dst = str2bytes(n);
        makePalindromic(dst);
        while (lower(src, dst)) {
            midDec(dst);
        }
        return bytes2str(dst);
    }

    private void midDec(byte[] n) {
        int start = getStart(n);
        int mid = (n.length - start) / 2 + start;
        if (n[mid]>0) {

        }
        switch (dec(n, mid)) {
            case 0:
                if (mid > 0) n[mid - 1] = n[mid];
                break;
            case 1:
                n[mid] = n[mid - 1];
                break;
            default:
                makePalindromic(n);
        }

    }


    private int dec(byte[] n, int offset) {
        if (n[offset] > 0) {
            n[offset]--;
            return 0;
        } else {
            n[offset] = 9;
            return dec(n, offset - 1) + 1;
        }
    }

    private int getStart(byte[] n) {
        int start = 0;
        while (n[start] == 0 && start < n.length - 1) {
            start++;
        }
        return start;
    }

    private void makePalindromic(byte[] n) {
        int start = getStart(n);
        int end = n.length - 1;
        for (int i = start; i < (n.length - start) / 2; i++) {
            n[end - i] = n[i];
        }
    }

    private boolean isPalindromic(byte[] n) {
        int start = getStart(n);
        int end = n.length - 1;
        for (int i = start; i < (n.length - start) / 2; i++) {
            if (n[end - i] != n[i]) return false;
        }
        return true;
    }

    private boolean lower(byte[] a, byte[] b) {
        if (a == null || b == null || a.length != b.length) return false;
        for (int i = 0; i < a.length; i++) {
            if (a[i] < b[i]) return true;
        }
        return false;
    }

    private byte[] str2bytes(String s) {
        byte[] ret = s.getBytes();
        for (int i = 0; i < ret.length; i++) {
            ret[i] -= (byte) '0';
        }
        return ret;
    }

    private String bytes2str(byte[] bs) {
        int start = getStart(bs);
        byte[] s = new byte[bs.length - start];
        for (int i = start; i < bs.length; i++) {
            s[i - start] = (byte) (bs[i] + (byte) '0');
        }
        return new String(bs);
    }
}