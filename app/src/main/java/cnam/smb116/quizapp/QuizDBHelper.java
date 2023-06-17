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
    protected static final int DATABASE_VERSION = 12;

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
        Question q0 = new Question("A 4-hour Sprint Planning meeting is typical for a Sprint or Iteration that is how long?","B","Four weeks","Two weeks","Four days","One week",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q0);
        Question q1 = new Question("What is the best definition of ‘Done’?","A","When a development work is ready for a release","When a product meets Product Owner expectations","When a product has passed Quality Assurance (QA) test and has all the required release documentation","When it is determined by the Scrum Master",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q1);
        Question q2 = new Question("How should multiple cohesive Scrum Teams be structured in order to produce integrated Increments on the same product?","A","Each Scrum Team develops all technical parts of functionality","Each Scrum Team only works on one technical layer of the system",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q2);
        Question q3 = new Question("Who can prematurely cancel or terminate a Sprint?","A","The Product Owner","The Developers","The Scrum Master","The customer",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q3);
        Question q4 = new Question("The IT Manager asks Developers for a status report describing the progress throughout the Sprint. How can the Scrum Master help the team?","C","Tell the Developers to produce the report by themselves","Create and deliver the report to the Manager him/herself","Explain to the IT Manager that the Sprint Review is a good opportunity to produce a status report","Ask the Product Owner to send the report to the Manager",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q4);
        Question q5 = new Question("What enhances the transparency of an Increment?","C","Updating Sprint tasks accurately in the electronic tracking tool","Doing all the work defined in the Sprint Backlog","Doing all the work needed to meet the Definition of Done","Reporting Sprint progress to the Stakeholders daily",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q5);
        Question q6 = new Question("How should multiple Scrum teams be created?","A","By asking the Developers to break into teams","By asking the Product Owner to assign people to the different teams","Assembling teams based on people skills across multiple application layers (such a database, UI, etc.)",null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q6);
        Question q7 = new Question("Which of the following best describes the Daily Scrum?","D","The meeting should ensure that it is clear to all which team members are not performing","There is no recommended length of time for the event","Everyone is expected to stand for the whole duration to keep the meeting short","Everyone is expected to keep the meeting short and to focus on Sprint Goals",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q7);
        Question q8 = new Question("In a Burndown Chart:","C","X tracks cost, Y tracks value","Y tracks value, Y tracks cost","X tracks time, Y tracks work","X tracks work, Y tracks time",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q8);
        Question q9 = new Question("Which answer best describes the Product Backlog?","B","It is a Baseline to follow as part of the Change Management processes","It is allowed to evolve and change as more is learned about the Product and its Customers","It contains all foreseeable tasks and requirements from which the Scrum Team can develop and maintain a complete Project Plan","It provides just enough information to enable a Scrum Team to start the design phase of a Product",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q9);
        Question q10 = new Question("A mature Scrum Team will execute at least one Release Sprint, as well as may release several.","B","True","False",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q10);
        Question q11 = new Question("How can a Scrum Master help Developers perform at their highest level of productivity?","C","Ensure that all meetings are kept within their Time-Box","Keep high-value features at high priority in the Product Backlog","Facilitate the Developers’ decisions and remove Impediments","Prevent changes to the Backlog once the Sprint begins",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q11);
        Question q12 = new Question("When Developers are having trouble delivering a usable Increment because they don’t understand a functional requirement, what should they do?","A","Work with the Product Owner to get information and agree on what is acceptable","Partially complete a functionality that should be part of the usable increment and discuss the remaining work at the Sprint Review","Recruit a specialist to work with the Developers","Defer the work to a more appropriate Sprint",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q12);
        Question q13 = new Question("When does an individual Developer take ownership of a Sprint Backlog item?","C","Whenever a team member can take-on additional work","During the Sprint Planning meeting","Never. All Sprint Backlog items are “owned” by the entire Scrum Team even though each one may be done by an individual Developer","During the Daily Scrum meeting",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q13);
        Question q14 = new Question("For the purpose of transparency, when does Scrum say that a new Increment of usable software must be made available?","E","At minimum, for every 3 Sprints","Just before a planned release","When the Product Owner asks to create one","After the Acceptance Testing phase is completed","At the end of every Sprint",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q14);
        Question q15 = new Question("Which best describes the role of a Product Owner?","D","A requirements’ engineer","A go-to subject matter expert between Developers and the Customers","A team Manager","A value Optimizer",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q15);
        Question q16 = new Question("The Product Owner must have defined the Sprint Goal before the Sprint Planning meeting.","B","True","False",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q16);
        Question q17 = new Question("Which of the following a Developer may deliver at the end of a Sprint?","A","An Increment of a usable software that is considered “Done”","An Increment or an addition of a new functionality of a software with minor known and acceptable bugs","Failing unit tests, to identify acceptance tests requirements for the next Sprint","A single document if that is what the Product Owner asked for",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q17);
        Question q18 = new Question("How can the Scrum Master ensure that the Developers communicate effectively with the Product Owner?","C","Act as a go-between for them","Teach the Developers to talk in terms of business needs and objectives","Monitor communications between them and facilitate direct collaboration","Teach the Product Owner about the technologies employed during the Sprints",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q18);
        Question q19 = new Question("Suppose 8 new members joined the Developers, and the team size is now very large. The Daily Scrum is getting noisy and exceeding the 15 minutes Time-Box. What is the most effective way to address this situation?","D","Do nothing; allow the large team to exceed the Time-Box by a few minutes at each meeting","Ask the members to update issues related to the Impediments only, as well as highlight the important ones","Increase the Time-Box for the Daily Scrum to 30 minutes","Divide the team into two teams that have minimum dependency on one another, and have two separate Daily Scrums",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q19);
        Question q20 = new Question("Which outcome is expected as Scrum Teams mature?","D","More than 4 hours Sprint Retrospectives","A Scrum Master is no longer needed since they are a mature team now","There is no need for a Time-Boxed Sprint since Time-Boxes are only for new Scrum teams","They will improve their Definition of Done to include more stringent criteria.","Sprint reviews will no longer be needed",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q20);
        Question q21 = new Question("Can a Product Owner be present at the Daily Scrum?","B","No, never","Yes, if he/she is actively working on items in the Sprint Backlog","Yes, always",null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q21);
        Question q22 = new Question("What are the mandatory prerequisites to the Sprint Planning meeting?","A","There are no mandatory prerequisites","The Sprint Goal","The Product Backlog with enough elements that are fully defined, along with relevant acceptance criteria, for the next Sprint","A proposed Sprint Backlog",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q22);
        Question q23 = new Question("A cross-functional Team in Scrum consists of which type of team member?","D","A Release Manager","A specialist in Quality Assurance (QA)","An Architect","Anyone with the skills to accomplish the work",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q23);
        Question q24 = new Question("When is the Sprint Backlog created?","C","During the Sprint","At the beginning of the project","During the Sprint Planning meeting","Prior to the Sprint Planning meeting",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q24);
        Question q25 = new Question("Who should talk about any adjustments that may be required from the selected work included in the Sprint Backlog?","D","The Developers","The Scrum Master, the Project Manager, and the Developers","The Product Owner and all Stakeholders","The Product Owner and the Developers",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q25);
        Question q26 = new Question("A new developer is confronted with continuing conflicts with existing Developers and creating a hostile environment. If necessary, who is responsible for removing the Team member?","C","The Product Owner is responsible because he/she controls the Return on Investment (ROI)","The Hiring Manager is responsible because he/she hired the Developer","The Developers are responsible and may need help from the Scrum Master","The Scrum Master is responsible because he/she removes Impediments",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q26);
        Question q27 = new Question("What is the primary purpose of the Sprint Review?","B","Celebrate success","Inspect the output of the Sprint with the Stakeholders and adapt the Product Backlog if needed","Demo the product","It is up to the Product Owner to decide",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q27);
        Question q28 = new Question("Match the Time-Box to the Sprint Review for a one-month Sprint","B","3 hours","4 hours","15 minutes","8 hours",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q28);
        Question q29 = new Question("A Product Owner wants advice from the Scrum Master about the Sizing Work activity in Scrum. Which of these is the guideline that a Scrum Master should give?","B","Scrum forbids Sizing","Sizing is completed by the Developers","Sizing is completed by the Product Owner but is best checked with the Developers","Sizing must be completed in Relative Units","Product Backlog Items must be Sized in Story Points",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q29);
        Question q30 = new Question("When can Developers cancel a Sprint?","A","They can’t. Only Product Owners can cancel Sprints","When the forecast for the Sprint becomes unachievable","When the Product Owner is frequently absent","When a technical dependency cannot be resolved","When functional expectations are not well understood",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q30);
        Question q31 = new Question("Drawing a Trend Line through a Release Burndown Chart indicates:","A","When the work remaining will likely be completed if nothing changes on the Backlog or the Developers’ scope","When the project will be over if the Product Owner removes work that is equal in effort to any new work that is added","The cost of the project","When all Sprint Backlog work will be completed",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q31);
        Question q32 = new Question("Which of the following statements is false?","D","A Product Owner can help clarify or optimize the Sprint when asked by the Developers","The Developers may work with the Product Owner to remove or add work if he/she finds they have more or less resources, skills and time available (Team Capacity) than it expected","The Sprint Backlog can change and may evolve as work emerges and therefore, breakdown of selected Items can be added","The Sprint Backlog and its contents are fully formulated in the Sprint Planning meeting and the Developers cannot add any additional work",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q32);
        Question q33 = new Question("The Product Owner must track the Developers’ velocity.","B","True","False",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q33);
        Question q34 = new Question("When should a Sprint Goal be created?","D","Before the Sprint Planning activity performed by the Product Owner","At any time during the Sprint","It should have been created in the previous Sprint during the Product Backlog refinement","During Sprint Planning","A Sprint Goal is not mandatory in Scrum",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q34);
        Question q35 = new Question("Who is responsible for engaging the Stakeholders?","E","The Project Manager","The Team Manager","The Developers","The main Customer","The Product Owner",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q35);
        Question q36 = new Question("Which two of the following items cannot be discussed in Sprint Retrospective? (Choose the best two options)","B;E","Team relations","Functionality implemented as a result of the Sprint","Definition of Done","Process improvements","Sprint Backlog for the next Sprint",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q36);
        Question q37 = new Question("The following are all inputs to the Sprint Planning meeting, for the exception of:","C","The Product Backlog","The Previous Increment","The Sprint Goal","Team Velocity",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q37);
        Question q38 = new Question("Which two activities are parts of the Product Owner’s accountability according to Scrum? (Choose the best two options)","B;E","Describing features as User Stories","Ensuring that the most valuable functionality is produced first, every time","Providing the Developers with detailed specifications","Creating detailed functional test cases","Working with Stakeholders",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q38);
        Question q39 = new Question("When is it most appropriate for Developers to change the “Definition of Done”?","A","During the Sprint Retrospective","During the Sprint Planning","Prior to starting a new Sprint","Prior to starting a new Project",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q39);
        Question q40 = new Question("A Baseline Product Backlog is called:","E","a Finished Plan","A Release Plan","A Sprint Backlog","A Product Roadmap","It is never Baselined; it is a living Artifact",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q40);
        Question q41 = new Question("Should the complete Scrum Team always attend the Sprint Planning?","A","True","False",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q41);
        Question q42 = new Question("Which of the following are members on a Scrum Team? (Choose all applicable options)","B;C;D","Users","Scrum Master","Product Owner","Developers","Customers",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q42);
        Question q43 = new Question("Which three of the following are Feedback Loops in Scrum? (Choose the best three options)","A;B;C","The Daily Scrum","The Sprint Review","The Sprint Retrospective","A Refinement Meeting","The Release Planning",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q43);
        Question q44 = new Question("If the Product Owner is not collaborating with the Developers during the Sprint, what should the Scrum Master do? (Choose the best two options)","B;C ","Cancel Scrum until a better Product Owner is identified","Coach the Product Owner on the values and benefits of Scrum and Incremental delivery","Raise the issue at the next Retrospective","Escalate to Senior Management",null,null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q44);
        Question q45 = new Question("An Iteration takes place in a time frame with specific start and end dates, called a Time-Box. Which of the following is NOT an advantage of Time-Boxing?","A","Helps control technical debt","Forces prioritization","Establishes a Work in Progress (WIP) limit","Demonstrates progress",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q45);
        Question q46 = new Question("The Three Pillars of Empirical Process Control are:","C","Transparency, Eliminating Waste, Kaizen","Planning, Inspection, Adaptation","Inspection, Transparency, Adaptation","Respect for People, Kaizen, Eliminating Waste","Planning, Demonstration, Retrospective",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q46);
        Question q47 = new Question("Who can update the Sprint Backlog during a Sprint?","A","The Developers","The Project Manager","The Scrum Team","The Product Owner",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q47);
        Question q48 = new Question("How can a Scrum Master help a Product Owner who has difficulties requesting the Product Backlog?","A","Offer the Product Owner help in ordering the Product Backlog understanding that the goal is to maximize value","Request the Product Backlog him/herself","Suggest the Product Owner to extend the Sprint so he/she can have more time to request the Product Backlog","Encourage the Product Owner to work with the Developers to see which items are fastest to implement","Ask the Developers to request the Product Backlog to confirm it is a feasible work order",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q48);
        Question q49 = new Question("Scrum requires a Scrum Master to foster an environment where: (Choose all applicable options)","A;B;C","A Product Owner orders the work for a complex problem into a Product Backlog","The Scrum Team converts a selection of the work into an Increment of Value during a Sprint.","The Scrum Team and its Stakeholders inspect the results and adjust for the next Sprint.","Product Backlog Items are fully Defined and Sized",null,null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q49);
        Question q50 = new Question("The Product Backlog should be transparent to the entire organization.","A","True","False",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q50);
        Question q51 = new Question("Which of the following is more important for leadership to provide in support of the Scrum implementation within their organization?","A","Values, principles, vision, and the freedom to explore practices within the boundaries those values create","Centralized methods and practices",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q51);
        Question q52 = new Question("Who is responsible for prioritizing the Product Backlog?","C","Management","The Developers","The Product Owner","The Scrum Master",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q52);
        Question q53 = new Question("What activities can a Product Owner do in the phase between the end of the current Sprint and the start of the next Sprint? (choose all applicable options)","A","There are no such activities. The next Sprint starts immediately after the current Sprint","Work with the Quality Assurance (QA) Department on the Increment of the current Sprint","Update the Project Plan with Stakeholders","Refine the Product Backlog",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q53);
        Question q54 = new Question("Which one of the following is NOT a Scrum Event?","A","the Weekly Status meeting","A Sprint Review","A Sprint","The Daily Scrum",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q54);
        Question q55 = new Question("Which of the following should NOT take place at the Daily Scrum?","C","The Developers answer the Three Questions - what will I do today, what have I done yesterday, what are the impediments?","The Developers manage the Time-Box","The Product Owner provides an update to Stakeholders","Issues are raised and documented",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q55);
        Question q56 = new Question("Who monitors the remaining work to be done during the Sprint?","B","Senior Executives","The Developers","The Product Owner","The Scrum Master",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q56);
        Question q57 = new Question("Who Sizes the Product Backlog Items?","B","The Product Owner with input from the Developers","The Developers after clarifying the requirements with the Product Owner","The most senior person in the organization, including Architects and subject matter experts","The Developers, by themselves","The Scrum Master",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q57);
        Question q58 = new Question("The Scrum Master is accountable for the Scrum Team’s effectiveness.","A","True","False",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q58);
        Question q59 = new Question("Please select the option(s) that do NOT adhere to the purpose of Sprint Retrospective: (Choose all applicable options)","B","Finding ways to increase product quality by adapting the Definition of Done as appropriate","Inspect how the product Increment satisfies the Product Backlog Items","Create a plan for implementing improvements adapted to the way the Scrum Team performs its daily work","Identify the Key Items that performed well and list the potential improvements",null,null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q59);
        Question q60 = new Question("The Developers are having difficulty understanding one of the items in the Product Backlog. As Scrum Master what should you do?","A","Talk to the Product Owner about it","Bring in an external expert","Ask them to research it","Bring it up at the Sprint Review",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q60);
        Question q61 = new Question("Which of the following is NOT part of the Scrum Framework?","A","Characteristics","Artifacts","Accountabilities","Events",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q61);
        Question q62 = new Question("Which Artifact contains the Product Goal as a commitment?","C","Increment","Sprint Backlog","Product Backlog","Definition of Done",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q62);
        Question q63 = new Question("The purpose of a Sprint is to produce a “Done” increment of working product.","A","True","False",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q63);
        Question q64 = new Question("If the Developers do not have all the necessary skills to reach the Sprint Goal, the Scrum Master should:","C","Remove the impacted Stories from the Sprint Backlog","Stop using Scrum","Work with the Scrum Team to see what is achievable in the current Sprint","Cancel the Sprint",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q64);
        Question q65 = new Question("The Scrum Master is accountable for the Scrum Team effectiveness?","A","True","False",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q65);
        Question q66 = new Question("How are architecture and infrastructure handled in Scrum?","B","They are addressed in the first Sprints","Alongside the functionalities: They are described and managed as a Product Backlog item","They are built by a separate team",null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q66);
        Question q67 = new Question("How complete should the Sprint Backlog be at the end of the Sprint Planning meeting?","A","Should include enough details to ensure that there is sufficient work for the first few days of the Sprint","It depends on the project","At minimum, every task should be defined and assigned","It depends on the ‘threshold for completeness’ set by the Product Owner",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q67);
        Question q68 = new Question("When should developers hold discussions and improve their engineering practices? (Choose the best two options)","B;E","During the Sprint Planning","During the Sprint Retrospective","Prior to starting a new Sprint","Prior to starting a new Project","Whenever needed",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q68);
        Question q69 = new Question("Which of the following statements is incorrect when assessing the Developers’ role?","D","The Developers are self-managing","The Developers are responsible for the Sprint Backlog","The Developers are cross-functional","A Product Owner who is actively working on items in the Sprint Backlog cannot be considered as a Developer",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q69);
        Question q70 = new Question("A Sprint may be cancelled prematurely when the Developers realize that the work is too hard for their skillset.","B","True","False",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q70);
        Question q71 = new Question("The Developers should be able to:","B","Complete the project within the date and cost as calculated by the Product Owner","Turn Product Backlog Items into an Increment of potentially releasable (usable is in the PPTX, not releasable… and why “potentially”?) product functionality","Complete all the development work, except for specialized testing that requires additional tools and environments",null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q71);
        Question q72 = new Question("Who is NOT part of the Scrum Team?","B","The Product Owner","Customers","Developers","The Scrum Master",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q72);
        Question q73 = new Question("Why do Developers need a Sprint Goal?","A","Developers are more focused with a common yet specific goal","Sprint Goals are not valuable. Everything is known from the Product Backlog","A Sprint Goal gives purpose to “Sprint 0”","A Sprint Goal ensures that all the Product Backlog Items selected for the Sprint are implemented",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q73);
        Question q74 = new Question("What is the purpose of a Sprint Review?","D","To build team spirit","To confirm the validity of the project","To assess the Scrum Team’s activities and processes during the Sprint","To inspect the product Increment with the Stakeholders and collect feedback that will influence what will be done in the next steps",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q74);
        Question q75 = new Question("Upon what type of process control is Scrum based on?","A","Empirical","Complex","Defined","Hybrid",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q75);
        Question q76 = new Question("Sprints can be shortened to a smaller time frame in order to limit the risk of cost and effort being exceeded","A","True","False",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q76);
        Question q77 = new Question("The person responsible for the Scrum process, making sure it is used correctly, maximizing its benefit, is responsibility of the:","B","Coach","Scrum Master","Product Owner","Scrum Manager",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q77);
        Question q78 = new Question("What happens if the Developers cannot complete their work by the end of the Sprint?","C","The Sprint is extended temporarily. Lessons-learn are noted to ensure it doesn’t happen again","The Sprint is extended, and future Sprints make use of this new duration","The Sprint length is maintained, and the Developers must learn and capitalize on what is possible to accomplish within a Sprint of this length",null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q78);
        Question q79 = new Question("Which three activities will a Product Owner likely engage in during a Sprint? (Choose the best three options)","B;D;E","Run the daily Scrum","Work with the Stakeholders","Update the Sprint Burndown Chart","Answer questions from the Developers about items in the current Sprint","Provide feedback","Prioritize the Developers’ activities",null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q79);
        Question q80 = new Question("What does a Burndown Chart track?","C","Accumulated business value delivered to the Customer","Individual worker productivity","Work remaining across time","Accumulated cost",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q80);
        Question q81 = new Question("Holding a “Sprint 0” is the most effective way to:","C","Work on team development","Define a reference architecture","There is no Sprint 0 in Scrum","Create a complete Product Backlog",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q81);
        Question q82 = new Question("Who is responsible to complete the work and confirm all Product Backlog items conform to the Definition of Done?","B","The Scrum Team","The Developers","Quality Assurance (QA) Specialists","The Product Owner","The Scrum Master",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q82);
        Question q83 = new Question("Time can be allocated between Sprints for integration testing","B","True","False",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q83);
        Question q84 = new Question("What is the Product Owner’s accountability during the Daily Scrum?","B","To hear about Impediments.","He/she doesn’t need to be there.","To participate as a Scrum Team member.","To represent the Stakeholders’ point of view.",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q84);
        Question q85 = new Question("During which meeting do Developers synchronize their work and highlight Impediments?","A","At the Daily Scrum","At the Weekly Status meeting","At the Sprint Planning meeting","At the Sprint Retrospective",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q85);
        Question q86 = new Question("Stakeholders can interact with the Scrum Team in which two ways? (Choose the best two options)","B;C","At the Daily Scrum","At the Sprint Review","Via interactions with the Product Owner","At the Sprint Retrospective",null,null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q86);
        Question q87 = new Question("What is the accountability of the Scrum Master? (Choose all applicable options)","B;C","The Scrum Master is responsible for updating the Sprint Burndown","The Scrum Master helps employees and Stakeholders understand and support an Empirical approach for complex work","The Scrum Master ensures that all Scrum Events take place and are positive, productive, and kept within the Time-box","The Scrum Master assigns tasks to the Developers when they need work","At the Sprint Review, the Scrum Master identifies what has been « Done » and what has not been « Done »",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q87);
        Question q88 = new Question("No one, not even the Scrum Master, tells the Developers how to build the product","A","True","False",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q88);
        Question q89 = new Question("Which topics are covered in Sprint Planning?","C","What went wrong in the last Sprint and what to do differently in this Sprint","What to do and who will do it","Why this sprint is valuable, what can be done and how to do it","How conditions have changed and how the Product Backlog should evolve","Who is on the team and what team members responsibilities will be",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q89);
        Question q90 = new Question("Every Scrum Team must have a Product Owner and Scrum Master","B","True and both must be 100% dedicated to the Scrum Team","True","False",null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q90);
        Question q91 = new Question("Which of the following are criteria when requesting the Product Backlog?","A","Whatever is deemed most appropriate by the Product Owner to commit to the product goal","List ‘small’ items at the top of the Product Backlog with ‘large’ items at the bottom","Items are randomly arranged and listed in the Product Backlog","Safer items are listed at the top with riskier items at the bottom","Least valuable items are listed at the top with most valuable listed at the bottom",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q91);
        Question q92 = new Question("What does a Trend Line in a Release Burndown Chart indicate?","A","When the work remaining will likely be completed if nothing changes in the Product Backlog or the Developers’ group","When all work will be completed so the Scrum Team can be released for other work","When the project will be over if the Product Owner removes work that is equal in effort to any new work that is added","The evolution of the team Velocity",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q92);
        Question q93 = new Question("Why the Definition of Done is an important Scrum element: (Choose the best three options)","A;B;C","Increases transparency","Guides the Developers on how many Product Backlog items to select for the Sprint","Creates a shared understanding of when the work is completed","Describes the purpose, objective, and Time-box of each Scrum event","Describes the work that must be done before the Sprint is allowed to end",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q93);
        Question q94 = new Question("Scrum is a software development method","B","True","False",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q94);
        Question q95 = new Question("Which two of the following statements are true about the Sprint Backlog? (Choose the best two options)","A;B","The Sprint Backlog will emerge during the Sprint","The Developers modify the Sprint Backlog during the Sprint","The Sprint Backlog does not change after the Sprint Planning meeting","The Product Owner decides on the Scope of the Sprint",null,null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q95);
        Question q96 = new Question("Your team is running three-week Sprints. How much time should you schedule for Sprint Review sessions?","C","1hour, 15 minutes","6 hours","3 hours","45 minutes",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q96);
        Question q97 = new Question("The Scrum Master provides support to which of the following?","C","The Developers","The Product Owner and the Developers","The Organization and the Scrum Team","The Organization",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q97);
        Question q98 = new Question("Which of the following statements is the MOST accurate?","C","Product Backlog Refinement is a full-time activity during a Sprint between the Scrum Master and the Developers","Product Backlog Refinement is a full-time activity between Sprints","Product Backlog Refinement is an ongoing activity during a Sprint undertaken by the Scrum Team","Product Backlog Refinement is a part-time activity during a Sprint between the Product Owner and stakeholders",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q98);
        Question q99 = new Question("When does the next Sprint begin?","A","Immediately after the end of the previous Sprint","Immediately after the next Sprint Planning","When the Product Owner is ready","The following Monday",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q99);
        Question q100 = new Question("Which of the following statements best describe the Sprint Backlog as outcome of the Sprint Planning?","A","It is the « why » and the plan which is used as input for the planning by Developers during the Sprint","Every Sprint Backlog Item has a designated owner","The Sprint Backlog is requested by the Product Owner","The Sprint Backlog is a complete list of all the work to be done in a Sprint","Each task of the Sprint Backlog is estimated in hours",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q100);
        Question q101 = new Question("If a customer really wants a feature added to a Sprint, how should the Developers respond?","C","Add the item to the Product Backlog for prioritization in the next Sprint","Add the feature to the current Sprint backlog","Ask the Product Owner to work with the customer","Escalate to the Scrum Master",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q101);
        Question q102 = new Question("Sprint Burndown Charts are an efficient tracking tool because they show:","C","How many Product Backlog Items remain","How many hours have been worked by each Developer","An estimate of the total work remaining for the Sprint","How much effort has gone into a Sprint",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q102);
        Question q103 = new Question("How can the Scrum Team ensure that security concerns are satisfied? (Choose the best two options)","A;E","Add security concerns to the Definition of Done","Schedule a Sprint to specifically resolve all security concerns","Assign the work to the security department","Postpone the work until a specialist can perform a security audit and create a list of securityrelated Product Backlog Items","Have the Scrum Team create Product Backlog Items for each concern",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q103);
        Question q104 = new Question("What is the major difference between Product Backlog and Sprint Backlog?","C","The Sprint Backlog is owned by the Product Owner","The Product Backlog is equal to the Sprint Backlog, in addition to the Sprint Goal","The Sprint Backlog includes a subset of the Product Backlog Items","The Product Backlog is a subset of the Sprint Backlog",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q104);
        Question q105 = new Question("How many Items of work is The Product Owner allowed to assign to Developers?","B","4","None","As many as he/she feels is necessary to maximize value","6",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q105);
        Question q106 = new Question("The optimal length of a Sprint is?","A","Short enough to minimize risk to the business but no more than one month","One-month","Two-weeks","One-week",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q106);
        Question q107 = new Question("When is a Product Backlog Item considered complete?","C","At the end of the Sprint","When all defined tasks are completed","When it adheres to the Definition of Done","When the Quality Assurance (QA) team reports that it has passed all acceptance criteria",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q107);
        Question q108 = new Question("When can the Scrum Team say that the Sprint is finished?","D","When all Product Backlog Items have attained their Definition of Done","When all the tasks are completed","When the Product Owner confirms it is done","When the Time-box expires",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q108);
        Question q109 = new Question("Twelve (12) Teams are working together on the same product. How many Product Backlogs should be used?","A","1","As many as the Product Owner feels is necessary","2 (includes 1 main plus the architectural backlog)","12","3 (includes 1 main, 1 architectural backlog and 1 security backlog)",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q109);
        Question q110 = new Question("Which two of the following best describe the Sprint Retrospective? (Choose the best two options)","B;C","It occurs before the Sprint Review","Its duration lasts three hours for a one-month Sprint","It is an opportunity to inspect relationships, processes and tools","It is the only time improvements are made during a Sprint",null,null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q110);
        Question q111 = new Question("How long is the Time-Box for the Daily Scrum?","C","Whatever the Team decides","It depends","15 minutes","5 minutes per Developer",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q111);
        Question q112 = new Question("If a Developer expresses his/her concerns to the Scrum Master about system performance issues of certain Backlog Items, what should the Scrum Master do?","B","Cancel the Sprint","Ask him/her to share the issue with all the Developers","Tell him/her to take their concerns to the Architect","Remove any impacted Items from the Backlog",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q112);
        Question q113 = new Question("Who is responsible for Sizing the work during a Sprint?","D","The most junior member of the Team","The Product Owner","The Scrum Master","The Developers",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q113);
        Question q114 = new Question("Which of the following are true about the Product Owner’s accountability? (Choose all applicable options)","A;C;D","The Product Owner can be influenced by the Stakeholders","Multiple people can share the Product Owner’s accountability","The Product Owner is one person","The Product Owner is accountable for ordering the Product Backlog",null,null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q114);
        Question q115 = new Question("Which topic should be discussed in the Sprint Review?","A","Sprint results","Coding and Engineering Practices","All of the above","The Scrum process, and how it was used during the Sprint",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q115);
        Question q116 = new Question("Who is responsible for determining when a new release is needed?","C","The Developers","The Scrum Master","The Product Owner","The Agile Project Manager",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q116);
        Question q117 = new Question("What Scrum Event or Artifact is the single source of requirements for any changes to be made to a product?","D","The Sprint","The Sprint Backlog","A Product that works","The Product Backlog","The Scrum Daily Meeting",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q117);
        Question q118 = new Question("If the Developers are not comfortable with the schedule of the Daily Scrum, what should the Scrum Master do?","A","Let the Developers come up with a new time schedule","Ask the Developers to try the existing time for one Sprint","Tell them that Scrum time schedule cannot be changed and that they need to stick to it","Find a time schedule that is open on everyone’s calendar",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q118);
        Question q119 = new Question("The Product Backlog is updated only during Backlog Refinement and Sprint Planning activities.","B","True","False",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q119);
        Question q120 = new Question("When is a Product Backlog Item considered completed?","B","When all corresponding Sprint Backlog Items are completed","When it meets the Scrum Team’s Definition of Done","When the Sprint from which it was selected ends","When all acceptance criteria are met",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q120);
        Question q121 = new Question("When does “Adaptation” occur in Scrum?","A","At all four formal Scrum Events","In the Daily Scrum","As part of the Sprint Retrospective","At the Sprint Review","During Sprint Planning activity",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q121);
        Question q122 = new Question("Which of the following statements is TRUE about the Product Owner?","C","The Product Owner modifies the Sprint Backlog by adding details","The Product Owner Sizes the work of the Sprint","The Product Owner is responsible to request the Product backlog","The Product Owner defines the Sprint Goal before the Sprint Planning meeting",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q122);
        Question q123 = new Question("Which Scrum Value is affected by a lack of trust in a Scrum Team?","F","Focus","Courage","Respect","Commitment","Openness","All of the above",null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q123);
        Question q124 = new Question("Which two of the following do not occur in the first Sprint? (Choose the best two options)","A;C","Define the complete architecture","Develop a new functionality","Finalize the complete Product Backlog","Create potentially releasable software",null,null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q124);
        Question q125 = new Question("What should the Developers do if the Product Owner is repeatedly too busy to be available?","B","Send the customer a written warning that the end product will be completed on time, but may not meet their needs","Discuss the matter with the Scrum Master","Continue the work, record the assumptions, and later ask the customer for input.","The Business Analyst should advise the Developers",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q125);
        Question q126 = new Question("Select five activities that are the responsibility of the Developers in Scrum (Choose the best five options)","A;B;C;I;J","Commit to the Sprint","Make technical decisions","Design software","Document all items in the form of User Stories","Champion/promote Scrum","Perform User Acceptance Tests","Facilitate meetings","Prioritize the Backlog","Volunteer for different tasks","Provide Sizing input to the Product Backlog",Question.QuestionType.MultipleChoice);
        addQuestion(q126);
        Question q127 = new Question("Who is the first speaker at the Daily Scrum?","C","The person coming in last","The last person who provoked an error in the build","Whoever the Developers decide should start","The Scrum Master","The person who has the “Token”",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q127);
        Question q128 = new Question("When does the second Sprint start?","B","After the customer completes the Acceptance Testing of the first Sprint","Immediately after the first Sprint","Once the architectural changes for the second Sprint have been approved by the senior Architect","After the Product Backlog for the second Sprint has been selected",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q128);
        Question q129 = new Question("What is the recommended size for a Scrum Team?","A","10 or fewer","9","Minimum 7","7, plus or minus 2 additional",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q129);
        Question q130 = new Question("When is a Sprint finished?","A","When the Time-boxed duration is met","When the Definition of Done is achieved for all selected Elements","When the Product Owner accepts the increment","When there is no work remaining",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q130);
        Question q131 = new Question("Select three activities that are the responsibility of the Scrum Master in Scrum (Choose the best three options)","C;G;H","Make technical decisions","Perform user acceptance tests","Facilitate meetings","Commit to the Sprint","Prioritize the Backlog","Volunteer for different tasks","Remove Impediments","Champion/promote Scrum","Sizing",null,Question.QuestionType.MultipleChoice);
        addQuestion(q131);
        Question q132 = new Question("Who is responsible for the Sizing?","A","The Developers","The Scrum Master","Management","The Product Owner",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q132);
        Question q133 = new Question("Select two statements that explain what “Done” means. (Choose the best two options)","D;E","Whatever the Product Owner defines as quality","When all the work the Developers are willing to do is completed","When the new product or item is ready for integration","When all activities to create a usable software have been completed","When there is no work left from the Definition of Done",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q133);
        Question q134 = new Question("At the end of a Sprint, a Product Backlog Item does not meet the Definition of Done. What should be done for this item? (Choose the best two options)","A;C","Add the Item on the Product Backlog for the Product Owner to decide what to do with it","Create a new Item for the remaining work","Do not include the Item in the Increment of this Sprint","If the Stakeholders agree, the Product Owner can accept it and release it to the users",null,null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q134);
        Question q135 = new Question("The feedback from the Sprint Review impacts the next Sprint Planning meeting","A","True","False",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q135);
        Question q136 = new Question("The Scrum Master should invite Stakeholders or Management to the Retrospective meeting","B","True","False",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q136);
        Question q137 = new Question("Which of the following are true about the length of the Sprint? (Choose the best two options)","B;D","Sprint length is determined during Sprint Planning","All Sprints must be 1 month in duration or less","The length of the Sprint should be proportional to the work that is done in between Sprints","Shorter Sprints can be used to generate more learning cycles",null,null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q137);
        Question q138 = new Question("Who assigns ownership of a Sprint Backlog Items during the Sprint?","B","Individual Developers","There is no single owner of a Product Backlog Item, the Developers owns the Sprint Backlog","Whoever has the skills","The Product Owner",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q138);
        Question q139 = new Question("Which statement best describes a Product Owner’s accountability?","D","Managing the project and ensuring that the work meets the commitments made to the Stakeholders","Directing the Developers and the Scrum Master","Keeping Stakeholders at bay","Maximizing the value of the product resulting from the work of the Scrum Team",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q139);
        Question q140 = new Question("How should Product Backlog Items be chosen when multiple Scrum Teams work on the same product?","D","The Scrum Team with the highest velocity work on Product Backlog Items first","Each Scrum Team takes an equal number of Items","The Product Owner should provide each team with its own Product Backlog","The Developers work on Product Backlog Items first in agreement with the Product Owner","The Product Owner decides who gets what",null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q140);
        Question q141 = new Question("The Product Backlog is Baselined at the start of the project and is not changed for at least three Sprints","B","True","False",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q141);
        Question q142 = new Question("Select three key concerns if the frequency of the daily meeting is lowered to every two or three days? (Choose the best three options)","A;B;C","Opportunities to inspect and adapt the Sprint Backlog are lost","Impediments are raised and resolved more slowly","The Sprint plan becomes inaccurate","Too much work is spent updating the Scrum Board before the meeting","The Scrum Master loses the ability to update the Gantt Chart properly","The Product Owner cannot report progress to the customers",null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q142);
        Question q143 = new Question("How often should the Developers group change?","C","Never, because it reduces productivity","Every Sprint to promote shared learning","As needed, while taking into account a short-term reduction in productivity",null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q143);
        Question q144 = new Question("What is the maximum length of a Sprint?","D","Not too long so that other business events cannot be readily synchronized with the development work","No more than one calendar month","Not too long so the risk does not become unacceptable to the Product Owner","All of these answers are correct",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q144);
        Question q145 = new Question("Which of the following statements is NOT true?","C","The Product Backlog is dynamic","The Product Backlog evolves as the product and the environment evolve","The Product Backlog is complete when the final product Increment is considered Done","The Product Backlog constantly changes in order to adapt to the changing requirements of the product",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q145);
        Question q146 = new Question("How can a Scrum Master help Developers who don’t have the engineering tools and infrastructure to completely finish each selected Product Backlog Item? (Choose the best two options)","A;D","Coach the Developers in improving their skills, tools, and infrastructure over time, and participate in adjusting the Definition of Done accordingly","Encourage the Product Owner to accept partially done Increments until the situation improves","Refocus the current Sprint on establishing the Developers’ infrastructure instead of delivering an Increment","Have the Scrum Team establish a Definition of Done that is actually possible to achieve given current circumstances","Declare the Developers not ready for Scrum",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q146);
        Question q147 = new Question("A Scrum Team…","C","Ensures that weak members of the team are allocated the simpler tasks","Ensures blame is allocated fairly","Collaborates and supports its team members","Is self-managing, with each member having the same technical skills",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q147);
        Question q148 = new Question("Which activities can be done during the Product Backlog refinement activity? (Choose all applicable options)","B;C;D;E","Conducting the second meeting held during the Sprint","Breaking down Product Backlog Items","Adding details to the Product Backlog Items","Ordering the Product Backlog Items","Sizing the Product Backlog items",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q148);
        Question q149 = new Question("While under development, the environment in which a product will be used changes and emerges. What is the effect on the Product Backlog?","D","It is archived and a new Product Backlog is created to replace the current one","It is converted into a Requirements Specification to ensure stability","There is no effect because it must remain unchanged until the end of the project","It evolves to reflect what the product needs to be to achieve its full value and benefits",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q149);
        Question q150 = new Question("In Scrum, the Developers decide which Events or Ceremonies take place during a Sprint","B","True","False",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q150);
        Question q151 = new Question("What happens if the customer no longer wants some of the key features that the Sprint Goal intended to achieve?","C","The Executive Stakeholders should determine if the Sprint should continue","The Scrum Master should cancel the Sprint","The Product Owner should cancel the Sprint","The Developers should determine if there is value in the Sprint",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q151);
        Question q152 = new Question("Which of the following does NOT describe Scrum?","D","A lightweight framework","Simple to understand","Difficult to master","A process or a technique for building products",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q152);
        Question q153 = new Question("How do you know if Developers have all the skills to be part of a Scrum Team?","C","If there are no conflicts between the Developers","A few of the Developers will do Pair Programming and do Test Driven Development (TDD)","When the Developers have all the skills to create a Usable Increment by the end of every Sprint","When every Developer is able to perform every task",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q153);
        Question q154 = new Question("If the Developers don’t appreciate holding the Daily Scrum meeting first thing in the morning, what should the Scrum Master do?","D","Tell them that Scrum meeting cannot be changed and that they need to stick to the agenda","Ask the Team to try the existing time for one Sprint and decide later","Reschedule the meeting to later in the day","Let the Developers come up with a new schedule",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q154);
        Question q155 = new Question("Which of the following occurs in the first Sprint?","C","The Product Roadmap is developed","The Reference Architecture is completed","A usable functionality is developed","A Project Plan is created",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q155);
        Question q156 = new Question("During a Sprint, when is new work or further breakdown of the work is to be added to the Sprint Backlog?","A","As soon as they are identified","When the Product Owner identifies new activities","During the Daily Scrum","When the Scrum Master has time to add these to the Sprint Backlog",null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q156);
        Question q157 = new Question("What should happen if it is discovered that the Developers do not have all the competencies needed to accomplish the work. (Choose the best three options)","C;D;E","Scrum Teams are cross functional, this never happens","The Sprint is put on hold until the right person joins the team","This will be discussed during the Sprint Retrospective meeting","The Developers re-negotiate the Sprint scope with the Product Owner","The Developers may not be able to Size how many Product Backlog Items can be done in a Sprint",null,null,null,null,null,Question.QuestionType.MultipleChoice);
        addQuestion(q157);
        Question q158 = new Question("If the Product Backlog is not ready for Sprint Planning, what happens next?","B","Extend the Sprint Planning to add enough details to the Backlog for one Sprint","Identify the work that can be undertaken the first day, ensure that the Product Owner is made aware of the situation and work to establish any missing details in the next few days","Cancel the Sprint until the Backlog is ready",null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q158);
        Question q159 = new Question("The primary reason one might choose a four-week Sprint is when there is too much work for a two week Sprint and because it cannot be broken-down any further","B","True","False",null,null,null,null,null,null,null,null,Question.QuestionType.SingleChoice);
        addQuestion(q159);
    }

    private void addQuestion(Question question) {
        ContentValues cv = new ContentValues();
        cv.put(QuestionsTable.COLUMN_QUESTION, question.getQuestion());
        cv.put(QuestionsTable.COLUMN_CORRECT_ANSWER, question.getCorrectAnswer());
        cv.put(QuestionsTable.COLUMN_OPTIONA, question.getOptionA());
        cv.put(QuestionsTable.COLUMN_OPTIONB, question.getOptionB());
        cv.put(QuestionsTable.COLUMN_OPTIONC, question.getOptionC());
        cv.put(QuestionsTable.COLUMN_OPTIOND, question.getOptionD());
        cv.put(QuestionsTable.COLUMN_OPTIONE, question.getOptionE());
        cv.put(QuestionsTable.COLUMN_OPTIONF, question.getOptionF());
        cv.put(QuestionsTable.COLUMN_OPTIONG, question.getOptionG());
        cv.put(QuestionsTable.COLUMN_OPTIONH, question.getOptionH());
        cv.put(QuestionsTable.COLUMN_OPTIONI, question.getOptionI());
        cv.put(QuestionsTable.COLUMN_OPTIONJ, question.getOptionJ());
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

    public int countQuestionsByType(Question.QuestionType type) {
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT COUNT(*) FROM " + QuestionsTable.TABLE_NAME+ " WHERE " + QuestionsTable.COLUMN_TYPE + "=?", new String[] {type.name()});
        c.moveToFirst();
        int count = c.getInt(0);
        c.close();
        return count;
    }

    @SuppressLint("Range")
    public ArrayList<Question> getAllQuestions() {
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME, null);
        return parseQuestions(c);
    }

    @SuppressLint("Range")
    public ArrayList<Question> getQuestionsByType(Question.QuestionType type) {
        db = getReadableDatabase();
        Cursor c = db.rawQuery("SELECT * FROM " + QuestionsTable.TABLE_NAME + " WHERE " + QuestionsTable.COLUMN_TYPE + "=?", new String[] {type.name()});
        return parseQuestions(c);
    }

    @SuppressLint("Range")
    public ArrayList<Question> parseQuestions(Cursor c) {
        ArrayList<Question> questionList = new ArrayList<>();
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
