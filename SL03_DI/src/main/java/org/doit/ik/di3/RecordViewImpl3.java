package org.doit.ik.di3;

import java.util.Scanner;

import javax.inject.Inject;
import javax.inject.Named;

import org.springframework.beans.factory.annotation.Autowired;

import lombok.Setter;

@Setter
public class RecordViewImpl3 implements RecordView3{
	
	//@Autowired
	@Inject
	@Named(value="record1")
	private RecordImpl3 record;
	
	public RecordViewImpl3() {
	}

	@Override
	public void input() {
		try (Scanner scanner = new Scanner(System.in)){
			System.out.print(">kor, eng, mat input ? ");
			int kor = scanner.nextInt();
			int eng = scanner.nextInt();
			int mat = scanner.nextInt();
			
			this.record.setKor(kor);
			this.record.setEng(eng);
			this.record.setMat(mat);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@Override
	public void output() {
		System.out.printf("> kor=%d, eng=%d, mat=%d, tot=%d, avg=%.2f\n"
				, this.record.getKor()
				, this.record.getEng()
				, this.record.getMat()
				, this.record.total()
				, this.record.avg()
				);
	}

} // class
