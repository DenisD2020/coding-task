package intewiew;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class Kuriba {

}

class ArrangeByParity {
    /**
     * The purpose of this function is to move all odd numbers to oddNumbers parameters and even numbers to evenNumbers parameters
     *
     * @param evenNumbers: array with possibly odd and even numbers
     * @param oddNumbers:  array with possibly odd and even numbers
     */
    public static void arrange(int[] evenNumbers, int[] oddNumbers) {
        int length = evenNumbers.length;
        int[] even = new int[length]; // O(2*n) memory
        int[] odd = new int[length]; //

        int evenIdx = 0, oddIdx = 0;
        for (int i = 0; i < length; i++) { // O(n) time compexity

            if (evenNumbers[i] % 2 == 0) {
                even[evenIdx++] = evenNumbers[i];
            } else {
                odd[oddIdx++] = evenNumbers[i];
            }

            if (oddNumbers[i] % 2 == 0) {
                even[evenIdx++] = oddNumbers[i];
            } else {
                odd[oddIdx++] = oddNumbers[i];
            }
        }

        System.arraycopy(even, 0, evenNumbers, 0, length); // O(n)
        System.arraycopy(odd, 0, oddNumbers, 0, length); // O(n)
    }

    public static void main(String[] args) {
        int[] evenNumbers = {1, 2, 3, 4, 5}; // odd
        int[] oddNumbers = {6, 7, 8, 9, 10};// even
        arrange(evenNumbers, oddNumbers);
        System.out.println(Arrays.toString(evenNumbers)); // 6,8,10,2,4
        System.out.println(Arrays.toString(oddNumbers)); //  1,3,5,7,9
    }
}

/**
 * Write a function that takes a Binary Tree and returns a list of its branch sums ordered from the leftmost branch sum to the rightmost branch sum.
 * A branch sum is the sum of all values in a Binary Tree branch. A Binary Tree branch is a path of nodes in a tree that starts at the root node and ends at any leaf node.
 * Each Binary Tree node has an integer value, a left child node and a right child node. Child nodes are Binary Tree themselves and are optional/nullable.
 * <p>
 * Sample Input :
 * <pre>
 * tree =                 1
 *                     /     \
 *                   2         3
 *                 /   \     /   \
 *                4      5   6     7
 *              /  \    /
 *             8    9  10
 * </pre>
 * <p>
 * Sample Output :
 * [15, 16, 18, 10, 11]
 * // 15=1+2+4+8
 * // 16=1+2+4+9
 * // 18=1+2+5+10
 * // 10=1+3+6
 * // 11=1+3+7
 */
class BranchSum {
    // This is the class of the input root. Do not edit it.
    public static class BinaryTree {
        int value;
        BinaryTree left;
        BinaryTree right;

        BinaryTree(int value) {
            this.value = value;
            this.left = null;
            this.right = null;
        }

        @Override
        public String toString() {
            return "BinaryTree{" +
                    "value=" + value +
                    ", left=" + left +
                    ", right=" + right +
                    '}';
        }
    }

    public static List<Integer> branchSums(final BinaryTree root) {
        return new ArrayList<>();
    }
}

class ReportRenderer {
    public static final int FORMAT_CSV = 1;
    public static final int FORMAT_XML = 2;
    public static final int FORMAT_HTML = 3;
    private static final int FORMAT_JSON = 4;
    private int format;
    private String reportName;
    private String title;
    private List<String> headers;
    private List<List<String>> data;
    private OutputStream fileStream;


    public ReportRenderer(int format, String reportName, String title, List<String> headers, List<List<String>> data) {
        this.format = format;
        this.reportName = reportName;
        this.title = title;
        this.headers = headers;
        this.data = data;
        render();
    }

    private void render() {
        try {
            fileStream = new FileOutputStream(reportName + "." + getExtension());
            prepareReport();
            writeHeader(headers);
            data.forEach(this::writeRow);
            finalizeReport();
            fileStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void prepareReport() {
        String content = "";
        switch (format) {
            case FORMAT_CSV:
                //no logic
                break;
            case FORMAT_XML:
                content = "<report>\n" +
                        "<title>" + title + "</title>\n";
                break;
            case FORMAT_HTML:
                content = "<html>\n" +
                        "<head><title>" + title + "</title></head>\n" +
                        "<body>\n" +
                        "<table>\n";
                break;
        }
        writeToFile(content);
    }

    private void writeToFile(String content) {
        try {
            fileStream.write(content.getBytes());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void writeHeader(List<String> headers) {
        String content = "";
        switch (format) {
            case FORMAT_CSV:
                content = String.join(";", headers) + "\n";
                break;
            case FORMAT_XML:
                content += "<headers>\n";
                content += headers.stream()
                        .map(header -> "<header>" + header + "</header>")
                        .collect(Collectors.joining("\n"));
                content += "\n</headers>\n";
                content += "<values>\n";
                break;
            case FORMAT_HTML:
                content += "<tr>\n";
                content += headers.stream()
                        .map(header -> "<th>" + header + "</th>")
                        .collect(Collectors.joining("\n"));
                content += "\n</tr>\n";
                break;
        }
        writeToFile(content);
    }


    public void writeRow(List<String> rowValues) {
        String content = "";
        switch (format) {
            case FORMAT_CSV:
                content = String.join(";", rowValues) + "\n";
                break;
            case FORMAT_XML:
                content += "<row>\n";
                content += rowValues.stream()
                        .map(cell -> "<cell>" + cell + "</cell>")
                        .collect(Collectors.joining("\n"));
                content += "\n</row>\n";
                break;
            case FORMAT_HTML:
                content += "<tr>\n";
                content += rowValues.stream()
                        .map(cell -> "<td>" + cell + "</td>")
                        .collect(Collectors.joining("\n"));
                content += "\n</tr>\n";
                break;
        }
        writeToFile(content);
    }

    public void finalizeReport() {
        String content = "";
        switch (format) {
            case FORMAT_CSV:
                //No logic
                break;
            case FORMAT_XML:
                content += "</values>\n" +
                        "</report>\n";
                break;
            case FORMAT_HTML:
                content += "</table>\n" +
                        "</body>\n" +
                        "</html>\n";
                break;
        }
        writeToFile(content);
    }

    public String getExtension() {
        switch (format) {
            case FORMAT_CSV:
                return "csv";
            case FORMAT_XML:
                return "xml";
            case FORMAT_HTML:
                return "html";
        }
        return null;
    }


    public static void main(String[] args) {
        List<String> headers = List.of("Beneficiary", "Debit account", "Amount");
        Random random = new Random();
        List<List<String>> values = IntStream.range(1, 101)
                .mapToObj(i -> List.of("Company " + i, "ACC " + (i), String.valueOf(random.nextInt(10_000))))
                .collect(Collectors.toList());

        new ReportRenderer(3, "payment2020", "Executed Payments 2020", headers, values);
    }
}
