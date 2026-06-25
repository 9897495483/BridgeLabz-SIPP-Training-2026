import java.util.Arrays;

public class MatrixAdvanced {

    public static double[][] transpose(
            double[][] matrix) {

        double[][] result =
                new double[matrix[0].length]
                        [matrix.length];

        for (int i=0;i<matrix.length;i++) {

            for (int j=0;j<matrix[0].length;j++) {

                result[j][i] =
                        matrix[i][j];
            }
        }

        return result;
    }

    public static double determinant2x2(
            double[][] m) {

        return (m[0][0] * m[1][1])
                -
                (m[0][1] * m[1][0]);
    }

    public static double[][] inverse2x2(
            double[][] m) {

        double det =
                determinant2x2(m);

        if(det == 0)
            return null;

        double[][] inverse =
                new double[2][2];

        inverse[0][0] =
                m[1][1] / det;

        inverse[0][1] =
                -m[0][1] / det;

        inverse[1][0] =
                -m[1][0] / det;

        inverse[1][1] =
                m[0][0] / det;

        return inverse;
    }

    public static void display(
            double[][] matrix) {

        for(double[] row : matrix)
            System.out.println(
                    Arrays.toString(row));
    }

    public static void main(String[] args) {

        double[][] matrix = {
                {4,7},
                {2,6}
        };

        System.out.println("Matrix");
        display(matrix);

        System.out.println("Transpose");
        display(transpose(matrix));

        System.out.println(
                "Determinant = "
                        + determinant2x2(matrix));

        System.out.println("Inverse");
        display(inverse2x2(matrix));
    }
}