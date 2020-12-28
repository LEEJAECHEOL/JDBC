package ch16.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PollListBean {
	private int num; // 설문 번호
	private String question; // 설문 내용
	private String sdate; // 투표시작 날짜
	private String edate; // 투표종료 날짜
	private String wdate; // 설문 작성 날짜
	private int type; // 중복투표 허용 여부
	private int active; // 설문 활성화 여부

}
