import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;
import java.util.Set;

class TotalScore {
	int divide;
	double total;
	double grade;
	double gradeScore;

}

class Grade {

	HashMap<Integer, Double> scoreMap = new HashMap<Integer, Double>();
	HashMap<Integer, TotalScore> totalMap = new HashMap<Integer, TotalScore>();

	private final static double TOTAL = 100;
	private final static int SUCESS_GRADE = 5;

	int subjects = 0;

	void total() {
		double score = 0;
		double perScore = 0;

		Scanner sc = new Scanner(System.in);

		System.out.println("������� ��������");
		subjects = sc.nextInt();

		score = (TOTAL / subjects);
		perScore = (TOTAL / subjects) / SUCESS_GRADE;

		for (int i = SUCESS_GRADE; i >= 1; i--) {
			scoreMap.put(i, score);
			System.out.println(i + ":" + score);

			score = score - perScore;
		}
	}

	void getRandom() {
		Scanner sc = new Scanner(System.in);
		int score = 0;

		System.out.println("������ ��������");
		score = sc.nextInt();

		double max = 0;
		while (true) {

			totalMap.clear();
			double total = 0;

			for (int i = 0; i < subjects; i++) {
				int random = (int) (Math.random() * 5) + 1;
				total = total + scoreMap.get(random);

				TotalScore totalScore = new TotalScore();
				totalScore.grade = random;
				totalScore.gradeScore = scoreMap.get(random);

				totalMap.put(i + 1, totalScore);
			}

			if (max < total) {
				max = total;
				System.out.println(score + "::" + total);
			}

			int cha = score - (int) total;

			if (cha == 0 || cha == 1 || cha == -1) {
				break;
			}
		}
		System.out.println("���ھ� �ϼ� �Ǿ����ϴ�.");
	}

	void getGrade() {
		Scanner sc = new Scanner(System.in);
		int divide = 0;

		System.out.println("�������� �Է� �ϼ���.");
		divide = sc.nextInt();

		double totalScore = 0;
		double gradeScore = 0;
		int i = 0;

		for (int key : totalMap.keySet()) {

			TotalScore ts = totalMap.get(key);

			if (i % divide == 0) {
				gradeScore = 0;
				gradeScore = gradeScore + ts.gradeScore;
			} else {
				gradeScore = gradeScore + ts.gradeScore;
			}

			totalScore = ts.gradeScore + totalScore;
			System.out.println("[��ȣ]," + i + "[�������]:" + ts.grade + ", [������� ����]:" + ts.gradeScore + ", [��ü ����]:"
					+ String.format("%.2f", gradeScore));

			i++;

		}

		System.out.println("[��ü ���ھ�]" + totalScore);

	}

	void getGrade2() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> listDivide = new ArrayList<Integer>();
		int divide = 0;

		System.out.println("���� ���ڵ��� �ְ� �������� 0�� �־� �ּ���");
		while (true) {
			divide = sc.nextInt();

			if (divide == 0)
				break;

			listDivide.add(divide);

		}

		double totalScore = 0;
		for (int num : listDivide) {

			double gradeScore = 0;
			int i = 0;

			for (int key : totalMap.keySet()) {
				TotalScore ts = totalMap.get(key);

				if (i == num) {
					gradeScore = 0;
					gradeScore = gradeScore + ts.gradeScore;
					// break;
				} else {
					gradeScore = gradeScore + ts.gradeScore;
				}

				totalScore = ts.gradeScore + totalScore;

				System.out.println("[��ȣ]," + i + "[�������]:" + ts.grade + ", [������� ����]:" + ts.gradeScore + ", [��ü ����]:"
						+ String.format("%.2f", gradeScore));

				i++;
			}

		}

		System.out.println("[��ü ���ھ�]" + totalScore);

	}

	void getGrade3() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> listDivide = new ArrayList<Integer>();
		int divide = 0;

		System.out.println("���� ���ڵ��� �ְ� �������� 0�� �־� �ּ���");
		while (true) {
			divide = sc.nextInt();

			if (divide == 0)
				break;

			listDivide.add(divide);

		}

		double totalScore = 0;
		double gradeScore = 0;
		int i = 0;
		for (int key : totalMap.keySet()) {



			int num = listDivide.get(0);
 
			TotalScore ts = totalMap.get(key);

			gradeScore = gradeScore + ts.gradeScore;

			totalScore = ts.gradeScore + totalScore;

			System.out.println("[��ȣ]," + i + "[�������]:" + ts.grade + ", [������� ����]:" + ts.gradeScore + ", [��ü ����]:"
					+ String.format("%.2f", gradeScore));

			i++;

			if ((i % num == 0)  && (i !=0)) {
				i=0;
				listDivide.remove(0);
				gradeScore= 0;
				System.out.println("========================================");
			}

		}

		System.out.println("[��ü ���ھ�]" + totalScore);

	}

}

public class GradeMain {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Grade grade = new Grade();

		grade.total();
		grade.getRandom();
		grade.getGrade3();

	}

}
