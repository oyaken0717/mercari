package com.example.controller;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.domain.Item;
import com.example.service.ItemService;

@Controller
@RequestMapping("/csv-download")
public class CsvDownloadController {
//
	@Autowired
	private ItemService itemService;

	@RequestMapping("/to-download")
	public String toDownload() {
		return "csv_download";
	}

	@RequestMapping("/download")
	public void download(){
		Integer page = 1;
		List<Item> itemList = new ArrayList<>();

		String path = "/Users/oyamadakenji/projects/ラクス/1.172.16.0.2/3.商品データ管理システム研修/80.追加課題/csv/item_all.csv";
		try {
//■ 「f」「p」はdo-whileの中にいれない。
			FileWriter f = new FileWriter(path, true);
			PrintWriter p = new PrintWriter(new BufferedWriter(f));
			// ■ ヘッダーを指定する
			p.print("id");
			p.print(",");
			p.print("商品名");
			p.print(",");
			p.print("価格");
			p.println();
			do {
				System.out.println("ーーーーーーーーー");
				System.out.println("SQL発行");
				System.out.println(page);
				itemList = itemService.findAll(page);
				// ■ 内容をセットする
				for (int i = 0; i < itemList.size(); i++) {
					p.print(itemList.get(i).getId());
					p.print(",");
					p.print(itemList.get(i).getName());
					p.print(",");
					p.print(itemList.get(i).getPrice());
					p.println();
				}
				p.close();
				page++;
			} while(itemList.size()!=0);
		} catch (IOException ex) {
			ex.printStackTrace();
		}		
	}
}
