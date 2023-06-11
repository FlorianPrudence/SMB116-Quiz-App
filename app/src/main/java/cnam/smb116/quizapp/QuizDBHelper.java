package cnam.smb116.quizapp;

import android.annotation.SuppressLint;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import java.util.ArrayList;

import cnam.smb116.quizapp.QuestionContract.QuestionsTable;

public class QuizDBHelper extends SQLiteOpenHelper {
    protected static final String DATABASE_NAME = "QuizApp.db";
    protected static final int DATABASE_VERSION = 11;

    private SQLiteDatabase db;

    public QuizDBHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        this.db = db;

        final String SQL_CREATE_QUESTIONS_TABLE = "CREATE TABLE " +
                QuestionsTable.TABLE_NAME + " ( " +
                QuestionsTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                QuestionsTable.COLUMN_QUESTION + " TEXT, " +
                QuestionsTable.COLUMN_CORRECT_ANSWER + " TEXT, " +
                QuestionsTable.COLUMN_OPTIONA + " TEXT, " +
                QuestionsTable.COLUMN_OPTIONB + " TEXT, " +
                QuestionsTable.COLUMN_OPTIONC + " TEXT, " +
                QuestionsTable.COLUMN_OPTIOND + " TEXT, " +
                QuestionsTable.COLUMN_OPTIONE + " TEXT, " +
                QuestionsTable.COLUMN_OPTIONF + " TEXT, " +
                QuestionsTable.COLUMN_OPTIONG + " TEXT, " +
                QuestionsTable.COLUMN_OPTIONH + " TEXT, " +
                QuestionsTable.COLUMN_OPTIONI + " TEXT, " +
                QuestionsTable.COLUMN_OPTIONJ + " TEXT, " +
                QuestionsTable.COLUMN_TYPE + " TEXT" +
                ")";

        final String SQL_CREATE_RESULTS_TABLE = "CREATE TABLE " +
                ResultContract.ResultTable.TABLE_NAME + " ( " +
                ResultContract.ResultTable._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                ResultContract.ResultTable.COLUMN_TIME + " INTEGER, " +
                ResultContract.ResultTable.COLUMN_CORRECT_ANSWERS + " TEXT, " +
                ResultContract.ResultTable.COLUMN_TOTAL_QUESTIONS + " TEXT " +
                ")";

        db.execSQL(SQL_CREATE_QUESTIONS_TABLE);
        db.execSQL(SQL_CREATE_RESULTS_TABLE);
        fillQuestionsTable();
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS " + QuestionContract.QuestionsTable.TABLE_NAME);
        db.execSQL("DROP TABLE IF EXISTS " + ResultContract.ResultTable.TABLE_NAME);
        onCreate(db);
    }

    private void fillQuestionsTable() {
        Question q0 = new Question("A 4-hour Sprint Planning meeting is typical for a Sprint or Iteration that is how long?","B","Four weeks","Four weeks","Four weeks","Four weeks",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q0);
        Question q1 = new Question("What is the best definition of ‘Done’?","A","When a development work is ready for a release","When a development work is ready for a release","When a development work is ready for a release","When a development work is ready for a release",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q1);
        Question q2 = new Question("How should multiple cohesive Scrum Teams be structured in order to produce integrated Increments on the same product?","A","Each Scrum Team develops all technical parts of functionality","Each Scrum Team develops all technical parts of functionality",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q2);
        Question q3 = new Question("Who can prematurely cancel or terminate a Sprint?","A","The Product Owner","The Product Owner","The Product Owner","The Product Owner",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q3);
        Question q4 = new Question("The IT Manager asks Developers for a status report describing the progress throughout the Sprint. How can the Scrum Master help the team?","C","Tell the Developers to produce the report by themselves","Tell the Developers to produce the report by themselves","Tell the Developers to produce the report by themselves","Tell the Developers to produce the report by themselves",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q4);
        Question q5 = new Question("What enhances the transparency of an Increment?","C","Updating Sprint tasks accurately in the electronic tracking tool","Updating Sprint tasks accurately in the electronic tracking tool","Updating Sprint tasks accurately in the electronic tracking tool","Updating Sprint tasks accurately in the electronic tracking tool",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q5);
        Question q6 = new Question("How should multiple Scrum teams be created?","A","By asking the Developers to break into teams","By asking the Developers to break into teams","By asking the Developers to break into teams",null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q6);
        Question q7 = new Question("Which of the following best describes the Daily Scrum?","D","The meeting should ensure that it is clear to all which team members are not performing","The meeting should ensure that it is clear to all which team members are not performing","The meeting should ensure that it is clear to all which team members are not performing","The meeting should ensure that it is clear to all which team members are not performing",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q7);
        Question q8 = new Question("In a Burndown Chart:","C","X tracks cost, Y tracks value","X tracks cost, Y tracks value","X tracks cost, Y tracks value","X tracks cost, Y tracks value",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q8);
        Question q9 = new Question("Which answer best describes the Product Backlog?","B","It is a Baseline to follow as part of the Change Management processes","It is a Baseline to follow as part of the Change Management processes","It is a Baseline to follow as part of the Change Management processes","It is a Baseline to follow as part of the Change Management processes",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q9);
        Question q10 = new Question("A mature Scrum Team will execute at least one Release Sprint, as well as may release several.","B","True","True",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q10);
        Question q11 = new Question("How can a Scrum Master help Developers perform at their highest level of productivity?","C","Ensure that all meetings are kept within their Time-Box","Ensure that all meetings are kept within their Time-Box","Ensure that all meetings are kept within their Time-Box","Ensure that all meetings are kept within their Time-Box",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q11);
        Question q12 = new Question("When Developers are having trouble delivering a usable Increment because they don’t understand a functional requirement, what should they do?","A","Work with the Product Owner to get information and agree on what is acceptable","Work with the Product Owner to get information and agree on what is acceptable","Work with the Product Owner to get information and agree on what is acceptable","Work with the Product Owner to get information and agree on what is acceptable",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q12);
        Question q13 = new Question("When does an individual Developer take ownership of a Sprint Backlog item?","C","Whenever a team member can take-on additional work","Whenever a team member can take-on additional work","Whenever a team member can take-on additional work","Whenever a team member can take-on additional work",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q13);
        Question q14 = new Question("For the purpose of transparency, when does Scrum say that a new Increment of usable software must be made available?","E","At minimum, for every 3 Sprints","At minimum, for every 3 Sprints","At minimum, for every 3 Sprints","At minimum, for every 3 Sprints","At minimum, for every 3 Sprints",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q14);
        Question q15 = new Question("Which best describes the role of a Product Owner?","D","A requirements’ engineer","A requirements’ engineer","A requirements’ engineer","A requirements’ engineer",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q15);
        Question q16 = new Question("The Product Owner must have defined the Sprint Goal before the Sprint Planning meeting.","B","True","True",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q16);
        Question q17 = new Question("Which of the following a Developer may deliver at the end of a Sprint?","A","An Increment of a usable software that is considered “Done”","An Increment of a usable software that is considered “Done”","An Increment of a usable software that is considered “Done”","An Increment of a usable software that is considered “Done”",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q17);
        Question q18 = new Question("How can the Scrum Master ensure that the Developers communicate effectively with the Product Owner?","C","Act as a go-between for them","Act as a go-between for them","Act as a go-between for them","Act as a go-between for them",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q18);
        Question q19 = new Question("Suppose 8 new members joined the Developers, and the team size is now very large. The Daily Scrum is getting noisy and exceeding the 15 minutes Time-Box. What is the most effective way to address this situation?","D","Do nothing; allow the large team to exceed the Time-Box by a few minutes at each meeting","Do nothing; allow the large team to exceed the Time-Box by a few minutes at each meeting","Do nothing; allow the large team to exceed the Time-Box by a few minutes at each meeting","Do nothing; allow the large team to exceed the Time-Box by a few minutes at each meeting",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q19);
        Question q20 = new Question("Which outcome is expected as Scrum Teams mature?","D","More than 4 hours Sprint Retrospectives","More than 4 hours Sprint Retrospectives","More than 4 hours Sprint Retrospectives","More than 4 hours Sprint Retrospectives","More than 4 hours Sprint Retrospectives",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q20);
        Question q21 = new Question("Can a Product Owner be present at the Daily Scrum?","B","No, never","No, never","No, never",null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q21);
        Question q22 = new Question("What are the mandatory prerequisites to the Sprint Planning meeting?","A","There are no mandatory prerequisites","There are no mandatory prerequisites","There are no mandatory prerequisites","There are no mandatory prerequisites",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q22);
        Question q23 = new Question("A cross-functional Team in Scrum consists of which type of team member?","D","A Release Manager","A Release Manager","A Release Manager","A Release Manager",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q23);
        Question q24 = new Question("When is the Sprint Backlog created?","C","During the Sprint","During the Sprint","During the Sprint","During the Sprint",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q24);
        Question q25 = new Question("Who should talk about any adjustments that may be required from the selected work included in the Sprint Backlog?","D","The Developers","The Developers","The Developers","The Developers",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q25);
        Question q26 = new Question("A new developer is confronted with continuing conflicts with existing Developers and creating a hostile environment. If necessary, who is responsible for removing the Team member?","C","The Product Owner is responsible because he/she controls the Return on Investment (ROI)","The Product Owner is responsible because he/she controls the Return on Investment (ROI)","The Product Owner is responsible because he/she controls the Return on Investment (ROI)","The Product Owner is responsible because he/she controls the Return on Investment (ROI)",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q26);
        Question q27 = new Question("What is the primary purpose of the Sprint Review?","B","Celebrate success","Celebrate success","Celebrate success","Celebrate success",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q27);
        Question q28 = new Question("Match the Time-Box to the Sprint Review for a one-month Sprint","B","3 hours","3 hours","3 hours","3 hours",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q28);
        Question q29 = new Question("A Product Owner wants advice from the Scrum Master about the Sizing Work activity in Scrum. Which of these is the guideline that a Scrum Master should give?","B","Scrum forbids Sizing","Scrum forbids Sizing","Scrum forbids Sizing","Scrum forbids Sizing","Scrum forbids Sizing",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q29);
        Question q30 = new Question("When can Developers cancel a Sprint?","A","They can’t. Only Product Owners can cancel Sprints","They can’t. Only Product Owners can cancel Sprints","They can’t. Only Product Owners can cancel Sprints","They can’t. Only Product Owners can cancel Sprints","They can’t. Only Product Owners can cancel Sprints",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q30);
        Question q31 = new Question("Drawing a Trend Line through a Release Burndown Chart indicates:","A","When the work remaining will likely be completed if nothing changes on the Backlog or the Developers’ scope","When the work remaining will likely be completed if nothing changes on the Backlog or the Developers’ scope","When the work remaining will likely be completed if nothing changes on the Backlog or the Developers’ scope","When the work remaining will likely be completed if nothing changes on the Backlog or the Developers’ scope",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q31);
        Question q32 = new Question("Which of the following statements is false?","D","A Product Owner can help clarify or optimize the Sprint when asked by the Developers","A Product Owner can help clarify or optimize the Sprint when asked by the Developers","A Product Owner can help clarify or optimize the Sprint when asked by the Developers","A Product Owner can help clarify or optimize the Sprint when asked by the Developers",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q32);
        Question q33 = new Question("The Product Owner must track the Developers’ velocity.","B","True","True",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q33);
        Question q34 = new Question("When should a Sprint Goal be created?","D","Before the Sprint Planning activity performed by the Product Owner","Before the Sprint Planning activity performed by the Product Owner","Before the Sprint Planning activity performed by the Product Owner","Before the Sprint Planning activity performed by the Product Owner","Before the Sprint Planning activity performed by the Product Owner",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q34);
        Question q35 = new Question("Who is responsible for engaging the Stakeholders?","E","The Project Manager","The Project Manager","The Project Manager","The Project Manager","The Project Manager",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q35);
        Question q36 = new Question("Which two of the following items cannot be discussed in Sprint Retrospective? (Choose the best two options)","B;E","Team relations","Team relations","Team relations","Team relations","Team relations",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q36);
        Question q37 = new Question("The following are all inputs to the Sprint Planning meeting, for the exception of:","C","The Product Backlog","The Product Backlog","The Product Backlog","The Product Backlog",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q37);
        Question q38 = new Question("Which two activities are parts of the Product Owner’s accountability according to Scrum? (Choose the best two options)","B;E","Describing features as User Stories","Describing features as User Stories","Describing features as User Stories","Describing features as User Stories","Describing features as User Stories",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q38);
        Question q39 = new Question("When is it most appropriate for Developers to change the “Definition of Done”?","A","During the Sprint Retrospective","During the Sprint Retrospective","During the Sprint Retrospective","During the Sprint Retrospective",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q39);
        Question q40 = new Question("A Baseline Product Backlog is called:","E","a Finished Plan","a Finished Plan","a Finished Plan","a Finished Plan","a Finished Plan",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q40);
        Question q41 = new Question("Should the complete Scrum Team always attend the Sprint Planning?","A","True","True",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q41);
        Question q42 = new Question("Which of the following are members on a Scrum Team? (Choose all applicable options)","B;C;D","Users","Users","Users","Users","Users",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q42);
        Question q43 = new Question("Which three of the following are Feedback Loops in Scrum? (Choose the best three options)","A;B;C","The Daily Scrum","The Daily Scrum","The Daily Scrum","The Daily Scrum","The Daily Scrum",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q43);
        Question q44 = new Question("If the Product Owner is not collaborating with the Developers during the Sprint, what should the Scrum Master do? (Choose the best two options)","B;C ","Cancel Scrum until a better Product Owner is identified","Cancel Scrum until a better Product Owner is identified","Cancel Scrum until a better Product Owner is identified","Cancel Scrum until a better Product Owner is identified",null,null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q44);
        Question q45 = new Question("An Iteration takes place in a time frame with specific start and end dates, called a Time-Box. Which of the following is NOT an advantage of Time-Boxing?","A","Helps control technical debt","Helps control technical debt","Helps control technical debt","Helps control technical debt",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q45);
        Question q46 = new Question("The Three Pillars of Empirical Process Control are:","C","Transparency, Eliminating Waste, Kaizen","Transparency, Eliminating Waste, Kaizen","Transparency, Eliminating Waste, Kaizen","Transparency, Eliminating Waste, Kaizen","Transparency, Eliminating Waste, Kaizen",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q46);
        Question q47 = new Question("Who can update the Sprint Backlog during a Sprint?","A","The Developers","The Developers","The Developers","The Developers",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q47);
        Question q48 = new Question("How can a Scrum Master help a Product Owner who has difficulties requesting the Product Backlog?","A","Offer the Product Owner help in ordering the Product Backlog understanding that the goal is to maximize value","Offer the Product Owner help in ordering the Product Backlog understanding that the goal is to maximize value","Offer the Product Owner help in ordering the Product Backlog understanding that the goal is to maximize value","Offer the Product Owner help in ordering the Product Backlog understanding that the goal is to maximize value","Offer the Product Owner help in ordering the Product Backlog understanding that the goal is to maximize value",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q48);
        Question q49 = new Question("Scrum requires a Scrum Master to foster an environment where: (Choose all applicable options)","A;B;C","A Product Owner orders the work for a complex problem into a Product Backlog","A Product Owner orders the work for a complex problem into a Product Backlog","A Product Owner orders the work for a complex problem into a Product Backlog","A Product Owner orders the work for a complex problem into a Product Backlog",null,null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q49);
        Question q50 = new Question("The Product Backlog should be transparent to the entire organization.","A","True","True",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q50);
        Question q51 = new Question("Which of the following is more important for leadership to provide in support of the Scrum implementation within their organization?","A","Values, principles, vision, and the freedom to explore practices within the boundaries those values create","Values, principles, vision, and the freedom to explore practices within the boundaries those values create",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q51);
        Question q52 = new Question("Who is responsible for prioritizing the Product Backlog?","C","Management","Management","Management","Management",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q52);
        Question q53 = new Question("What activities can a Product Owner do in the phase between the end of the current Sprint and the start of the next Sprint? (choose all applicable options)","A","There are no such activities. The next Sprint starts immediately after the current Sprint","There are no such activities. The next Sprint starts immediately after the current Sprint","There are no such activities. The next Sprint starts immediately after the current Sprint","There are no such activities. The next Sprint starts immediately after the current Sprint",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q53);
        Question q54 = new Question("Which one of the following is NOT a Scrum Event?","A","the Weekly Status meeting","the Weekly Status meeting","the Weekly Status meeting","the Weekly Status meeting",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q54);
        Question q55 = new Question("Which of the following should NOT take place at the Daily Scrum?","C","The Developers answer the Three Questions - what will I do today, what have I done yesterday, what are the impediments?","The Developers answer the Three Questions - what will I do today, what have I done yesterday, what are the impediments?","The Developers answer the Three Questions - what will I do today, what have I done yesterday, what are the impediments?","The Developers answer the Three Questions - what will I do today, what have I done yesterday, what are the impediments?",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q55);
        Question q56 = new Question("Who monitors the remaining work to be done during the Sprint?","B","Senior Executives","Senior Executives","Senior Executives","Senior Executives",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q56);
        Question q57 = new Question("Who Sizes the Product Backlog Items?","B","The Product Owner with input from the Developers","The Product Owner with input from the Developers","The Product Owner with input from the Developers","The Product Owner with input from the Developers","The Product Owner with input from the Developers",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q57);
        Question q58 = new Question("The Scrum Master is accountable for the Scrum Team’s effectiveness.","A","True","True",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q58);
        Question q59 = new Question("Please select the option(s) that do NOT adhere to the purpose of Sprint Retrospective: (Choose all applicable options)","B","Finding ways to increase product quality by adapting the Definition of Done as appropriate","Finding ways to increase product quality by adapting the Definition of Done as appropriate","Finding ways to increase product quality by adapting the Definition of Done as appropriate","Finding ways to increase product quality by adapting the Definition of Done as appropriate",null,null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q59);
        Question q60 = new Question("The Developers are having difficulty understanding one of the items in the Product Backlog. As Scrum Master what should you do?","A","Talk to the Product Owner about it","Talk to the Product Owner about it","Talk to the Product Owner about it","Talk to the Product Owner about it",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q60);
        Question q61 = new Question("Which of the following is NOT part of the Scrum Framework?","A","Characteristics","Characteristics","Characteristics","Characteristics",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q61);
        Question q62 = new Question("Which Artifact contains the Product Goal as a commitment?","C","Increment","Increment","Increment","Increment",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q62);
        Question q63 = new Question("The purpose of a Sprint is to produce a “Done” increment of working product.","A","True","True",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q63);
        Question q64 = new Question("If the Developers do not have all the necessary skills to reach the Sprint Goal, the Scrum Master should:","C","Remove the impacted Stories from the Sprint Backlog","Remove the impacted Stories from the Sprint Backlog","Remove the impacted Stories from the Sprint Backlog","Remove the impacted Stories from the Sprint Backlog",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q64);
        Question q65 = new Question("The Scrum Master is accountable for the Scrum Team effectiveness?","A","True","True",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q65);
        Question q66 = new Question("How are architecture and infrastructure handled in Scrum?","B","They are addressed in the first Sprints","They are addressed in the first Sprints","They are addressed in the first Sprints",null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q66);
        Question q67 = new Question("How complete should the Sprint Backlog be at the end of the Sprint Planning meeting?","A","Should include enough details to ensure that there is sufficient work for the first few days of the Sprint","Should include enough details to ensure that there is sufficient work for the first few days of the Sprint","Should include enough details to ensure that there is sufficient work for the first few days of the Sprint","Should include enough details to ensure that there is sufficient work for the first few days of the Sprint",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q67);
        Question q68 = new Question("When should developers hold discussions and improve their engineering practices? (Choose the best two options)","B;E","During the Sprint Planning","During the Sprint Planning","During the Sprint Planning","During the Sprint Planning","During the Sprint Planning",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q68);
        Question q69 = new Question("Which of the following statements is incorrect when assessing the Developers’ role?","D","The Developers are self-managing","The Developers are self-managing","The Developers are self-managing","The Developers are self-managing",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q69);
        Question q70 = new Question("A Sprint may be cancelled prematurely when the Developers realize that the work is too hard for their skillset.","B","True","True",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q70);
        Question q71 = new Question("The Developers should be able to:","B","Complete the project within the date and cost as calculated by the Product Owner","Complete the project within the date and cost as calculated by the Product Owner","Complete the project within the date and cost as calculated by the Product Owner",null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q71);
        Question q72 = new Question("Who is NOT part of the Scrum Team?","B","The Product Owner","The Product Owner","The Product Owner","The Product Owner",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q72);
        Question q73 = new Question("Why do Developers need a Sprint Goal?","A","Developers are more focused with a common yet specific goal","Developers are more focused with a common yet specific goal","Developers are more focused with a common yet specific goal","Developers are more focused with a common yet specific goal",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q73);
        Question q74 = new Question("What is the purpose of a Sprint Review?","D","To build team spirit","To build team spirit","To build team spirit","To build team spirit",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q74);
        Question q75 = new Question("Upon what type of process control is Scrum based on?","A","Empirical","Empirical","Empirical","Empirical",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q75);
        Question q76 = new Question("Sprints can be shortened to a smaller time frame in order to limit the risk of cost and effort being exceeded","A","True","True",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q76);
        Question q77 = new Question("The person responsible for the Scrum process, making sure it is used correctly, maximizing its benefit, is responsibility of the:","B","Coach","Coach","Coach","Coach",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q77);
        Question q78 = new Question("What happens if the Developers cannot complete their work by the end of the Sprint?","C","The Sprint is extended temporarily. Lessons-learn are noted to ensure it doesn’t happen again","The Sprint is extended temporarily. Lessons-learn are noted to ensure it doesn’t happen again","The Sprint is extended temporarily. Lessons-learn are noted to ensure it doesn’t happen again",null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q78);
        Question q79 = new Question("Which three activities will a Product Owner likely engage in during a Sprint? (Choose the best three options)","B;D;E","Run the daily Scrum","Run the daily Scrum","Run the daily Scrum","Run the daily Scrum","Run the daily Scrum","Run the daily Scrum",null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q79);
        Question q80 = new Question("What does a Burndown Chart track?","C","Accumulated business value delivered to the Customer","Accumulated business value delivered to the Customer","Accumulated business value delivered to the Customer","Accumulated business value delivered to the Customer",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q80);
        Question q81 = new Question("Holding a “Sprint 0” is the most effective way to:","C","Work on team development","Work on team development","Work on team development","Work on team development",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q81);
        Question q82 = new Question("Who is responsible to complete the work and confirm all Product Backlog items conform to the Definition of Done?","B","The Scrum Team","The Scrum Team","The Scrum Team","The Scrum Team","The Scrum Team",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q82);
        Question q83 = new Question("Time can be allocated between Sprints for integration testing","B","True","True",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q83);
        Question q84 = new Question("What is the Product Owner’s accountability during the Daily Scrum?","B","To hear about Impediments.","To hear about Impediments.","To hear about Impediments.","To hear about Impediments.",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q84);
        Question q85 = new Question("During which meeting do Developers synchronize their work and highlight Impediments?","A","At the Daily Scrum","At the Daily Scrum","At the Daily Scrum","At the Daily Scrum",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q85);
        Question q86 = new Question("Stakeholders can interact with the Scrum Team in which two ways? (Choose the best two options)","B;C","At the Daily Scrum","At the Daily Scrum","At the Daily Scrum","At the Daily Scrum",null,null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q86);
        Question q87 = new Question("What is the accountability of the Scrum Master? (Choose all applicable options)","B;C","The Scrum Master is responsible for updating the Sprint Burndown","The Scrum Master is responsible for updating the Sprint Burndown","The Scrum Master is responsible for updating the Sprint Burndown","The Scrum Master is responsible for updating the Sprint Burndown","The Scrum Master is responsible for updating the Sprint Burndown",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q87);
        Question q88 = new Question("No one, not even the Scrum Master, tells the Developers how to build the product","A","True","True",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q88);
        Question q89 = new Question("Which topics are covered in Sprint Planning?","C","What went wrong in the last Sprint and what to do differently in this Sprint","What went wrong in the last Sprint and what to do differently in this Sprint","What went wrong in the last Sprint and what to do differently in this Sprint","What went wrong in the last Sprint and what to do differently in this Sprint","What went wrong in the last Sprint and what to do differently in this Sprint",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q89);
        Question q90 = new Question("Every Scrum Team must have a Product Owner and Scrum Master","B","True and both must be 100% dedicated to the Scrum Team","True and both must be 100% dedicated to the Scrum Team","True and both must be 100% dedicated to the Scrum Team",null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q90);
        Question q91 = new Question("Which of the following are criteria when requesting the Product Backlog?","A","Whatever is deemed most appropriate by the Product Owner to commit to the product goal","Whatever is deemed most appropriate by the Product Owner to commit to the product goal","Whatever is deemed most appropriate by the Product Owner to commit to the product goal","Whatever is deemed most appropriate by the Product Owner to commit to the product goal","Whatever is deemed most appropriate by the Product Owner to commit to the product goal",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q91);
        Question q92 = new Question("What does a Trend Line in a Release Burndown Chart indicate?","A","When the work remaining will likely be completed if nothing changes in the Product Backlog or the Developers’ group","When the work remaining will likely be completed if nothing changes in the Product Backlog or the Developers’ group","When the work remaining will likely be completed if nothing changes in the Product Backlog or the Developers’ group","When the work remaining will likely be completed if nothing changes in the Product Backlog or the Developers’ group",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q92);
        Question q93 = new Question("Why the Definition of Done is an important Scrum element: (Choose the best three options)","A;B;C","Increases transparency","Increases transparency","Increases transparency","Increases transparency","Increases transparency",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q93);
        Question q94 = new Question("Scrum is a software development method","B","True","True",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q94);
        Question q95 = new Question("Which two of the following statements are true about the Sprint Backlog? (Choose the best two options)","A;B","The Sprint Backlog will emerge during the Sprint","The Sprint Backlog will emerge during the Sprint","The Sprint Backlog will emerge during the Sprint","The Sprint Backlog will emerge during the Sprint",null,null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q95);
        Question q96 = new Question("Your team is running three-week Sprints. How much time should you schedule for Sprint Review sessions?","C","1hour, 15 minutes","1hour, 15 minutes","1hour, 15 minutes","1hour, 15 minutes",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q96);
        Question q97 = new Question("The Scrum Master provides support to which of the following?","C","The Developers","The Developers","The Developers","The Developers",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q97);
        Question q98 = new Question("Which of the following statements is the MOST accurate?","C","Product Backlog Refinement is a full-time activity during a Sprint between the Scrum Master and the Developers","Product Backlog Refinement is a full-time activity during a Sprint between the Scrum Master and the Developers","Product Backlog Refinement is a full-time activity during a Sprint between the Scrum Master and the Developers","Product Backlog Refinement is a full-time activity during a Sprint between the Scrum Master and the Developers",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q98);
        Question q99 = new Question("When does the next Sprint begin?","A","Immediately after the end of the previous Sprint","Immediately after the end of the previous Sprint","Immediately after the end of the previous Sprint","Immediately after the end of the previous Sprint",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q99);
        Question q100 = new Question("Which of the following statements best describe the Sprint Backlog as outcome of the Sprint Planning?","A","It is the « why » and the plan which is used as input for the planning by Developers during the Sprint","It is the « why » and the plan which is used as input for the planning by Developers during the Sprint","It is the « why » and the plan which is used as input for the planning by Developers during the Sprint","It is the « why » and the plan which is used as input for the planning by Developers during the Sprint","It is the « why » and the plan which is used as input for the planning by Developers during the Sprint",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q100);
        Question q101 = new Question("If a customer really wants a feature added to a Sprint, how should the Developers respond?","C","Add the item to the Product Backlog for prioritization in the next Sprint","Add the item to the Product Backlog for prioritization in the next Sprint","Add the item to the Product Backlog for prioritization in the next Sprint","Add the item to the Product Backlog for prioritization in the next Sprint",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q101);
        Question q102 = new Question("Sprint Burndown Charts are an efficient tracking tool because they show:","C","How many Product Backlog Items remain","How many Product Backlog Items remain","How many Product Backlog Items remain","How many Product Backlog Items remain",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q102);
        Question q103 = new Question("How can the Scrum Team ensure that security concerns are satisfied? (Choose the best two options)","A;E","Add security concerns to the Definition of Done","Add security concerns to the Definition of Done","Add security concerns to the Definition of Done","Add security concerns to the Definition of Done","Add security concerns to the Definition of Done",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q103);
        Question q104 = new Question("What is the major difference between Product Backlog and Sprint Backlog?","C","The Sprint Backlog is owned by the Product Owner","The Sprint Backlog is owned by the Product Owner","The Sprint Backlog is owned by the Product Owner","The Sprint Backlog is owned by the Product Owner",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q104);
        Question q105 = new Question("How many Items of work is The Product Owner allowed to assign to Developers?","B","4","4","4","4",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q105);
        Question q106 = new Question("The optimal length of a Sprint is?","A","Short enough to minimize risk to the business but no more than one month","Short enough to minimize risk to the business but no more than one month","Short enough to minimize risk to the business but no more than one month","Short enough to minimize risk to the business but no more than one month",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q106);
        Question q107 = new Question("When is a Product Backlog Item considered complete?","C","At the end of the Sprint","At the end of the Sprint","At the end of the Sprint","At the end of the Sprint",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q107);
        Question q108 = new Question("When can the Scrum Team say that the Sprint is finished?","D","When all Product Backlog Items have attained their Definition of Done","When all Product Backlog Items have attained their Definition of Done","When all Product Backlog Items have attained their Definition of Done","When all Product Backlog Items have attained their Definition of Done","When all Product Backlog Items have attained their Definition of Done","When all Product Backlog Items have attained their Definition of Done","When all Product Backlog Items have attained their Definition of Done","When all Product Backlog Items have attained their Definition of Done","When all Product Backlog Items have attained their Definition of Done","When all Product Backlog Items have attained their Definition of Done",Question.QuestionType.SingleChoice);
        addQuestion(q108);
        Question q109 = new Question("Which two of the following best describe the Sprint Retrospective? (Choose the best two options)","B;C","It occurs before the Sprint Review","It occurs before the Sprint Review","It occurs before the Sprint Review","It occurs before the Sprint Review",null,null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q109);
        Question q110 = new Question("How long is the Time-Box for the Daily Scrum?","C","Whatever the Team decides","Whatever the Team decides","Whatever the Team decides","Whatever the Team decides",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q110);
        Question q111 = new Question("If a Developer expresses his/her concerns to the Scrum Master about system performance issues of certain Backlog Items, what should the Scrum Master do?","B","Cancel the Sprint","Cancel the Sprint","Cancel the Sprint","Cancel the Sprint",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q111);
        Question q112 = new Question("Who is responsible for Sizing the work during a Sprint?","D","The most junior member of the Team","The most junior member of the Team","The most junior member of the Team","The most junior member of the Team",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q112);
        Question q113 = new Question("Which of the following are true about the Product Owner’s accountability? (Choose all applicable options)","A;C;D","The Product Owner can be influenced by the Stakeholders","The Product Owner can be influenced by the Stakeholders","The Product Owner can be influenced by the Stakeholders","The Product Owner can be influenced by the Stakeholders",null,null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q113);
        Question q114 = new Question("Which topic should be discussed in the Sprint Review?","A","Sprint results","Sprint results","Sprint results","Sprint results",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q114);
        Question q115 = new Question("Who is responsible for determining when a new release is needed?","C","The Developers","The Developers","The Developers","The Developers",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q115);
        Question q116 = new Question("What Scrum Event or Artifact is the single source of requirements for any changes to be made to a product?","D","The Sprint","The Sprint","The Sprint","The Sprint","The Sprint",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q116);
        Question q117 = new Question("If the Developers are not comfortable with the schedule of the Daily Scrum, what should the Scrum Master do?","A","Let the Developers come up with a new time schedule","Let the Developers come up with a new time schedule","Let the Developers come up with a new time schedule","Let the Developers come up with a new time schedule",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q117);
        Question q118 = new Question("The Product Backlog is updated only during Backlog Refinement and Sprint Planning activities.","B","True","True",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q118);
        Question q119 = new Question("When is a Product Backlog Item considered completed?","B","When all corresponding Sprint Backlog Items are completed","When all corresponding Sprint Backlog Items are completed","When all corresponding Sprint Backlog Items are completed","When all corresponding Sprint Backlog Items are completed",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q119);
        Question q120 = new Question("When does “Adaptation” occur in Scrum?","A","At all four formal Scrum Events","At all four formal Scrum Events","At all four formal Scrum Events","At all four formal Scrum Events","At all four formal Scrum Events",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q120);
        Question q121 = new Question("Which of the following statements is TRUE about the Product Owner?","C","The Product Owner modifies the Sprint Backlog by adding details","The Product Owner modifies the Sprint Backlog by adding details","The Product Owner modifies the Sprint Backlog by adding details","The Product Owner modifies the Sprint Backlog by adding details",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q121);
        Question q122 = new Question("Which Scrum Value is affected by a lack of trust in a Scrum Team?","F","Focus","Focus","Focus","Focus","Focus","Focus",null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q122);
        Question q123 = new Question("Which two of the following do not occur in the first Sprint? (Choose the best two options)","A;C","Define the complete architecture","Define the complete architecture","Define the complete architecture","Define the complete architecture",null,null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q123);
        Question q124 = new Question("What should the Developers do if the Product Owner is repeatedly too busy to be available?","B","Send the customer a written warning that the end product will be completed on time, but may not meet their needs","Send the customer a written warning that the end product will be completed on time, but may not meet their needs","Send the customer a written warning that the end product will be completed on time, but may not meet their needs","Send the customer a written warning that the end product will be completed on time, but may not meet their needs",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q124);
        Question q125 = new Question("Select five activities that are the responsibility of the Developers in Scrum (Choose the best five options)","A;B;C;I;J","Commit to the Sprint","Commit to the Sprint","Commit to the Sprint","Commit to the Sprint","Commit to the Sprint","Commit to the Sprint","Commit to the Sprint","Commit to the Sprint","Commit to the Sprint","Commit to the Sprint",Question.QuestionType.MultipleChoice);
        addQuestion(q125);
        Question q126 = new Question("Who is the first speaker at the Daily Scrum?","C","The person coming in last","The person coming in last","The person coming in last","The person coming in last","The person coming in last",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q126);
        Question q127 = new Question("When does the second Sprint start?","B","After the customer completes the Acceptance Testing of the first Sprint","After the customer completes the Acceptance Testing of the first Sprint","After the customer completes the Acceptance Testing of the first Sprint","After the customer completes the Acceptance Testing of the first Sprint",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q127);
        Question q128 = new Question("What is the recommended size for a Scrum Team?","A","10 or fewer","10 or fewer","10 or fewer","10 or fewer",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q128);
        Question q129 = new Question("When is a Sprint finished?","A","When the Time-boxed duration is met","When the Time-boxed duration is met","When the Time-boxed duration is met","When the Time-boxed duration is met",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q129);
        Question q130 = new Question("Select three activities that are the responsibility of the Scrum Master in Scrum (Choose the best three options)","C;G;H","Make technical decisions","Make technical decisions","Make technical decisions","Make technical decisions","Make technical decisions","Make technical decisions","Make technical decisions","Make technical decisions","Make technical decisions",null,Question.QuestionType.MultipleChoice);
        addQuestion(q130);
        Question q131 = new Question("Who is responsible for the Sizing?","A","The Developers","The Developers","The Developers","The Developers",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q131);
        Question q132 = new Question("Select two statements that explain what “Done” means. (Choose the best two options)","D;E","Whatever the Product Owner defines as quality","Whatever the Product Owner defines as quality","Whatever the Product Owner defines as quality","Whatever the Product Owner defines as quality","Whatever the Product Owner defines as quality",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q132);
        Question q133 = new Question("At the end of a Sprint, a Product Backlog Item does not meet the Definition of Done. What should be done for this item? (Choose the best two options)","A;C","Add the Item on the Product Backlog for the Product Owner to decide what to do with it","Add the Item on the Product Backlog for the Product Owner to decide what to do with it","Add the Item on the Product Backlog for the Product Owner to decide what to do with it","Add the Item on the Product Backlog for the Product Owner to decide what to do with it",null,null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q133);
        Question q134 = new Question("The feedback from the Sprint Review impacts the next Sprint Planning meeting","A","True","True",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q134);
        Question q135 = new Question("The Scrum Master should invite Stakeholders or Management to the Retrospective meeting","B","True","True",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q135);
        Question q136 = new Question("Which of the following are true about the length of the Sprint? (Choose the best two options)","B;D","Sprint length is determined during Sprint Planning","Sprint length is determined during Sprint Planning","Sprint length is determined during Sprint Planning","Sprint length is determined during Sprint Planning",null,null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q136);
        Question q137 = new Question("Who assigns ownership of a Sprint Backlog Items during the Sprint?","B","Individual Developers","Individual Developers","Individual Developers","Individual Developers",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q137);
        Question q138 = new Question("Which statement best describes a Product Owner’s accountability?","D","Managing the project and ensuring that the work meets the commitments made to the Stakeholders","Managing the project and ensuring that the work meets the commitments made to the Stakeholders","Managing the project and ensuring that the work meets the commitments made to the Stakeholders","Managing the project and ensuring that the work meets the commitments made to the Stakeholders",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q138);
        Question q139 = new Question("How should Product Backlog Items be chosen when multiple Scrum Teams work on the same product?","D","The Scrum Team with the highest velocity work on Product Backlog Items first","The Scrum Team with the highest velocity work on Product Backlog Items first","The Scrum Team with the highest velocity work on Product Backlog Items first","The Scrum Team with the highest velocity work on Product Backlog Items first","The Scrum Team with the highest velocity work on Product Backlog Items first",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q139);
        Question q140 = new Question("The Product Backlog is Baselined at the start of the project and is not changed for at least three Sprints","B","True","True",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q140);
        Question q141 = new Question("Select three key concerns if the frequency of the daily meeting is lowered to every two or three days? (Choose the best three options)","A;B;C","Opportunities to inspect and adapt the Sprint Backlog are lost","Opportunities to inspect and adapt the Sprint Backlog are lost","Opportunities to inspect and adapt the Sprint Backlog are lost","Opportunities to inspect and adapt the Sprint Backlog are lost","Opportunities to inspect and adapt the Sprint Backlog are lost","Opportunities to inspect and adapt the Sprint Backlog are lost",null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q141);
        Question q142 = new Question("How often should the Developers group change?","C","Never, because it reduces productivity","Never, because it reduces productivity","Never, because it reduces productivity",null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q142);
        Question q143 = new Question("What is the maximum length of a Sprint?","D","Not too long so that other business events cannot be readily synchronized with the development work","Not too long so that other business events cannot be readily synchronized with the development work","Not too long so that other business events cannot be readily synchronized with the development work","Not too long so that other business events cannot be readily synchronized with the development work",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q143);
        Question q144 = new Question("Which of the following statements is NOT true?","C","The Product Backlog is dynamic","The Product Backlog is dynamic","The Product Backlog is dynamic","The Product Backlog is dynamic",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q144);
        Question q145 = new Question("How can a Scrum Master help Developers who don’t have the engineering tools and infrastructure to completely finish each selected Product Backlog Item? (Choose the best two options)","A;D","Coach the Developers in improving their skills, tools, and infrastructure over time, and participate in adjusting the Definition of Done accordingly","Coach the Developers in improving their skills, tools, and infrastructure over time, and participate in adjusting the Definition of Done accordingly","Coach the Developers in improving their skills, tools, and infrastructure over time, and participate in adjusting the Definition of Done accordingly","Coach the Developers in improving their skills, tools, and infrastructure over time, and participate in adjusting the Definition of Done accordingly","Coach the Developers in improving their skills, tools, and infrastructure over time, and participate in adjusting the Definition of Done accordingly",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q145);
        Question q146 = new Question("A Scrum Team…","C","Ensures that weak members of the team are allocated the simpler tasks","Ensures that weak members of the team are allocated the simpler tasks","Ensures that weak members of the team are allocated the simpler tasks","Ensures that weak members of the team are allocated the simpler tasks",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q146);
        Question q147 = new Question("Which activities can be done during the Product Backlog refinement activity? (Choose all applicable options)","B;C;D;E","Conducting the second meeting held during the Sprint","Conducting the second meeting held during the Sprint","Conducting the second meeting held during the Sprint","Conducting the second meeting held during the Sprint","Conducting the second meeting held during the Sprint",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q147);
        Question q148 = new Question("While under development, the environment in which a product will be used changes and emerges. What is the effect on the Product Backlog?","D","It is archived and a new Product Backlog is created to replace the current one","It is archived and a new Product Backlog is created to replace the current one","It is archived and a new Product Backlog is created to replace the current one","It is archived and a new Product Backlog is created to replace the current one",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q148);
        Question q149 = new Question("In Scrum, the Developers decide which Events or Ceremonies take place during a Sprint","B","True","True",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q149);
        Question q150 = new Question("What happens if the customer no longer wants some of the key features that the Sprint Goal intended to achieve?","C","The Executive Stakeholders should determine if the Sprint should continue","The Executive Stakeholders should determine if the Sprint should continue","The Executive Stakeholders should determine if the Sprint should continue","The Executive Stakeholders should determine if the Sprint should continue",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q150);
        Question q151 = new Question("Which of the following does NOT describe Scrum?","D","A lightweight framework","A lightweight framework","A lightweight framework","A lightweight framework",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q151);
        Question q152 = new Question("How do you know if Developers have all the skills to be part of a Scrum Team?","C","If there are no conflicts between the Developers","If there are no conflicts between the Developers","If there are no conflicts between the Developers","If there are no conflicts between the Developers",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q152);
        Question q153 = new Question("If the Developers don’t appreciate holding the Daily Scrum meeting first thing in the morning, what should the Scrum Master do?","D","Tell them that Scrum meeting cannot be changed and that they need to stick to the agenda","Tell them that Scrum meeting cannot be changed and that they need to stick to the agenda","Tell them that Scrum meeting cannot be changed and that they need to stick to the agenda","Tell them that Scrum meeting cannot be changed and that they need to stick to the agenda",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q153);
        Question q154 = new Question("Which of the following occurs in the first Sprint?","C","The Product Roadmap is developed","The Product Roadmap is developed","The Product Roadmap is developed","The Product Roadmap is developed",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q154);
        Question q155 = new Question("During a Sprint, when is new work or further breakdown of the work is to be added to the Sprint Backlog?","A","As soon as they are identified","As soon as they are identified","As soon as they are identified","As soon as they are identified",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q155);
        Question q156 = new Question("What should happen if it is discovered that the Developers do not have all the competencies needed to accomplish the work. (Choose the best three options)","C;D;E","Scrum Teams are cross functional, this never happens","Scrum Teams are cross functional, this never happens","Scrum Teams are cross functional, this never happens","Scrum Teams are cross functional, this never happens","Scrum Teams are cross functional, this never happens",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q156);
        Question q157 = new Question("If the Product Backlog is not ready for Sprint Planning, what happens next?","B","Extend the Sprint Planning to add enough details to the Backlog for one Sprint","Extend the Sprint Planning to add enough details to the Backlog for one Sprint","Extend the Sprint Planning to add enough details to the Backlog for one Sprint",null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q157);
        Question q158 = new Question("The primary reason one might choose a four-week Sprint is when there is too much work for a two week Sprint and because it cannot be broken-down any further","B","True","True",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q158);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_CORRECT_ANSWER, question.getCorrectAnswer());
        cv.put(QuestionsTable.COLUMN_OPTIONA, question.getOptionA());
        cv.put(QuestionsTable.COLUMN_OPTIONB, question.getOptionB());
        cv.put(QuestionsTable.COLUMN_OPTIONC, question.getOptionC());
        cv.put(QuestionsTable.COLUMN_OPTIOND, question.getOptionD());
        cv.put(QuestionsTable.COLUMN_OPTIONE, question.getOptionD());
        cv.put(QuestionsTable.COLUMN_OPTIONF, question.getOptionD());
        cv.put(QuestionsTable.COLUMN_OPTIONG, question.getOptionD());
        cv.put(QuestionsTable.COLUMN_OPTIONH, question.getOptionD());
        cv.put(QuestionsTable.COLUMN_OPTIONI, question.getOptionD());
        cv.put(QuestionsTable.COLUMN_OPTIONJ, question.getOptionD());
        cv.put(QuestionsTable.COLUMN_TYPE, question.getType().name());
        db.insert(QuestionsTable.TABLE_NAME, null, cv);
    }

    public int countAllQuestions() {
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT COUNT(*) FROM " + QuestionsTable.TABLE_NAME, null);
        c.moveToFirst();
        int count = c.getInt(0);
        c.close();
        return count;
    }

    @SuppressLint("Range")
    public ArrayList<Question> getAllQuestions() {
        ArrayList<Question> questionList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);

        if (c.moveToFirst()) {
            do {
                Question question = new Question();
                question.setQuestion(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_QUESTION)));
                question.setCorrectAnswer(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_CORRECT_ANSWER)));
                question.setOptionA(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTIONA)));
                question.setOptionB(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTIONB)));
                question.setOptionC(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTIONC)));
                question.setOptionD(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTIOND)));
                question.setOptionE(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTIONE)));
                question.setOptionF(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTIONF)));
                question.setOptionG(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTIONG)));
                question.setOptionH(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTIONH)));
                question.setOptionI(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTIONI)));
                question.setOptionJ(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_OPTIONJ)));
                question.setType(Question.QuestionType.valueOf(c.getString(c.getColumnIndex(QuestionsTable.COLUMN_TYPE))));
                questionList.add(question);
            } while (c.moveToNext());
        }

        c.close();
        return questionList;
    }

    public long insertResult(int correctAnswers, int totalQuestions) {
        ContentValues values = new ContentValues();
        values.put(ResultContract.ResultTable.COLUMN_TIME, System.currentTimeMillis());
        values.put(ResultContract.ResultTable.COLUMN_CORRECT_ANSWERS, correctAnswers);
        values.put(ResultContract.ResultTable.COLUMN_TOTAL_QUESTIONS, totalQuestions);
        return db.insert(ResultContract.ResultTable.TABLE_NAME, null, values);
    }

    @SuppressLint("Range")
    public ArrayList<Result> getAllResult() {
        ArrayList<Result> resultList = new ArrayList<>();
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + ResultContract.ResultTable.TABLE_NAME + " ORDER BY " + ResultContract.ResultTable.COLUMN_TIME + " DESC", null);

        if (c.moveToFirst()) {
            do {
                Result result = new Result();
                result.setTime(c.getLong(c.getColumnIndex(ResultContract.ResultTable.COLUMN_TIME)));
                result.setCorrectAnswers(c.getInt(c.getColumnIndex(ResultContract.ResultTable.COLUMN_CORRECT_ANSWERS)));
                result.setTotalQuestions(c.getInt(c.getColumnIndex(ResultContract.ResultTable.COLUMN_TOTAL_QUESTIONS)));
                resultList.add(result);
            } while (c.moveToNext());
        }

        c.close();
        return resultList;
    }
}
