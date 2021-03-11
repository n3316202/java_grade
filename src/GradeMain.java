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

		System.out.println("과목수를 넣으세요");
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

		System.out.println("점수를 넣으세요");
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
		System.out.println("스코어 완성 되었습니다.");
	}

	void getGrade() {
		Scanner sc = new Scanner(System.in);
		int divide = 0;

		System.out.println("나눌수를 입력 하세요.");
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
			System.out.println("[번호]," + i + "[성취수준]:" + ts.grade + ", [성취수준 점수]:" + ts.gradeScore + ", [전체 점수]:"
					+ String.format("%.2f", gradeScore));

			i++;

		}

		System.out.println("[전체 스코어]" + totalScore);

	}

	void getGrade2() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> listDivide = new ArrayList<Integer>();
		int divide = 0;

		System.out.println("나눌 숫자들을 넣고 마지막은 0로 넣어 주세요");
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

				System.out.println("[번호]," + i + "[성취수준]:" + ts.grade + ", [성취수준 점수]:" + ts.gradeScore + ", [전체 점수]:"
						+ String.format("%.2f", gradeScore));

				i++;
			}

		}

		System.out.println("[전체 스코어]" + totalScore);

	}

	void getGrade3() {
		Scanner sc = new Scanner(System.in);
		ArrayList<Integer> listDivide = new ArrayList<Integer>();
		int divide = 0;

		System.out.println("나눌 숫자들을 넣고 마지막은 0로 넣어 주세요");
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

			System.out.println("[번호]," + i + "[성취수준]:" + ts.grade + ", [성취수준 점수]:" + ts.gradeScore + ", [전체 점수]:"
					+ String.format("%.2f", gradeScore));

			i++;

			if ((i % num == 0)  && (i !=0)) {
				i=0;
				listDivide.remove(0);
				gradeScore= 0;
				System.out.println("========================================");
			}

		}

		System.out.println("[전체 스코어]" + totalScore);

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
