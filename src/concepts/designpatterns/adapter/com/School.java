package concepts.designpatterns.adapter.com;

public class School {

    public static void main(String[] args) {

           /*
                For writing the assignment we need the pen. But we don't know how to implement the pen.
                But we have another class Pencil which has nothing to do with Pen but have the same functionality implement.
                So what we need is an adapter class which can take the Pen and utilises the Pencil object.
            */

        Pen pen = new PenAdapter();
        AssignmentWork assignmentWork = new AssignmentWork();
        assignmentWork.setPen(pen);
        assignmentWork.writeAssignment("Hello World");
    }
}
