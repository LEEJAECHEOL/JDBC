package ch16.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class PollItemBean {
	private int listnum; // 설문번호 
	private int itemnum; // 아이템 번호
	private String [] item; // 아이템 내용
	private int count; // 투표수
}
