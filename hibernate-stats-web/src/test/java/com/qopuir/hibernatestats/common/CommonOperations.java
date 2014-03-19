package com.qopuir.hibernatestats.common;

import static com.ninja_squad.dbsetup.Operations.deleteAllFrom;
import static com.ninja_squad.dbsetup.Operations.insertInto;
import static com.ninja_squad.dbsetup.Operations.sequenceOf;

import com.ninja_squad.dbsetup.operation.Operation;

public class CommonOperations {
	public static final Operation DELETE_ALL = deleteAllFrom("EMPLOYEE");
	
	public static final Operation INSERT_REFERENCE_DATA =
	        sequenceOf(
                insertInto("EMPLOYEE")
	                .columns("ID", "FIRSTNAME", "LASTNAME", "EMAIL", "TELEPHONE")
	                .row().column("ID", 1).column("FIRSTNAME", "TEST1").column("LASTNAME", "TEST1").column("EMAIL", "TEST1@TEST1.COM").column("TELEPHONE", "987654321").end()
	                .row().column("ID", 2).column("FIRSTNAME", "TEST2").column("LASTNAME", "TEST2").column("EMAIL", "TEST2@TEST1.COM").column("TELEPHONE", "987654321").end()
	                .useMetadata(false)
	                .build()
	        );
}