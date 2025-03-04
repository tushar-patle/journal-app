package com.tushar.journal.entity;

import java.time.LocalDateTime;

import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;

@Document(collection = "journal")
@Getter
@Setter
@NoArgsConstructor
public class JournalEntry {

	@Id
	private ObjectId id;
	@NonNull
	private String title;

	private String content;

	private LocalDateTime date;
}
