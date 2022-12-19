package objects;

public class ComplexNumberBase {

    public static void main(String[] args) {
        AsciiCharSequence asciiCharSequence = new AsciiCharSequence(new byte[]{1, 2, 3, 4, 5});
        System.out.println(asciiCharSequence.subSequence(1, 3).toString());
    }


    public static class AsciiCharSequence implements java.lang.CharSequence {

        byte[] value;

        public AsciiCharSequence(byte[] value) {
            this.value = value;
        }

        @Override
        public int length() {
            return value.length;
        }

        @Override
        public char charAt(int index) {
            return (char) value[index];
        }

        @Override
        public CharSequence subSequence(int start, int end) {
            int l = end - start;
            byte[] subSeq = new byte[l];
            int index = start;
            for (int i = 0; i < subSeq.length; i++) {
                subSeq[i] = value[index];
                index++;
            }
            return new AsciiCharSequence(subSeq);
        }

        @Override
        public String toString() {
            StringBuilder builder = new StringBuilder();

            for (int i = 0; i < value.length; i++) {
                builder.append((char) value[i]);
            }
            return builder.toString();
        }
    }

    public static class ComplexNumber {
        private double re;
        private double im;

        public ComplexNumber() {
        }

        public ComplexNumber(double re, double im) {
            this.re = re;
            this.im = im;
        }

        public double getRe() {
            return re;
        }

        public double getIm() {
            return im;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;

            ComplexNumber that = (ComplexNumber) o;

            if (Double.compare(that.re, re) != 0) return false;
            return Double.compare(that.im, im) == 0;
        }

        @Override
        public int hashCode() {
            int result;
            long temp;
            temp = Double.doubleToLongBits(re);
            result = (int) (temp ^ (temp >>> 32));
            temp = Double.doubleToLongBits(im);
            result = 31 * result + (int) (temp ^ (temp >>> 32));
            return result;
        }
    }
}

