package etc;

import java.util.HashMap;

public class StringCount {
	public static void main(String[] args) {
		String str1 = "6aoddbe1bs56daaz4eho12lhno8"; // str1의 각 문자의 갯수를 카운트해서
														// 출력하시오

		HashMap<String, Integer> strMap = new HashMap<String, Integer>();

		for (int i = 0; i < str1.length(); i++) {
			String temp = str1.substring(i, i + 1);

			if (i == 0) { // 초기값셋팅
				strMap.put(temp, 1);

			} else {

				if (strMap.get(temp) == null) {
					strMap.put(temp, 1);
				} else {
					strMap.put(temp, strMap.get(temp) + 1);
				}

			}

		}// for end

		// System.out.println("map : " + strMap);
		// System.out.println("map key : " + strMap.keySet());
		// System.out.println("map key : " + strMap.values());

		Object[] key = strMap.keySet().toArray();

		for (int j = 0; j < strMap.size(); j++) {
			System.out.println(key[j] + "의 개수는 : " + strMap.get(key[j]));
		}

	}
}