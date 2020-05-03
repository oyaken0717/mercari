package com.example.service;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.domain.Category;
import com.example.domain.Item;

@Service
@Transactional
public class CsvOutputService {
	
	public void outputItem(Item item) {

		try {
			String path = "/Users/oyamadakenji/projects/ラクス/1.172.16.0.2/3.商品データ管理システム研修/80.追加課題/csv/item.csv";
			FileWriter f = new FileWriter(path, false);
			PrintWriter p = new PrintWriter(new BufferedWriter(f));

			// ■ ヘッダーを指定する
			p.print("商品ID");
			p.print(",");
			p.print("商品名");
			p.print(",");
			p.print("カテゴリー");
			p.print(",");
			p.print("プライス");
			p.println();

			// ■ 内容をセットする
				p.print(item.getId());
				p.print(",");
				p.print(item.getName());
				p.print(",");
				p.print(item.getCategoryName());
				p.print(",");
				p.print(item.getPrice());
				// ■ 改行
				p.println();

			// ■ ファイルに書き出し閉じる
			p.close();
			System.out.println("ファイル出力完了！");
		} catch (IOException ex) {
			ex.printStackTrace();
		//■tryの終わり
		}
	//■ メソッドの終わり
	} 
	
	public void outputCategory(Category category) {

		try {
			String path = "/Users/oyamadakenji/projects/ラクス/1.172.16.0.2/3.商品データ管理システム研修/80.追加課題/csv/category.csv";
			FileWriter f = new FileWriter(path, false);
			PrintWriter p = new PrintWriter(new BufferedWriter(f));

			// ■ ヘッダーを指定する
			p.print("カテゴリーID");
			p.print(",");
			p.print("カテゴリー名");
			p.println();

			// ■ 内容をセットする
				p.print(category.getId());
				p.print(",");
				p.print(category.getName());
				// ■ 改行
				p.println();

			// ■ ファイルに書き出し閉じる
			p.close();
			System.out.println("ファイル出力完了！");
		} catch (IOException ex) {
			ex.printStackTrace();
		//■tryの終わり
		}
	//■ メソッドの終わり
	} 

}
