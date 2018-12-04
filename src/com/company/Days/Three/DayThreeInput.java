package com.company.Days.Three;

import com.company.Days.DayInput;
import com.company.Node;
import com.company.Reader;

import java.io.IOException;

public class DayThreeInput extends DayInput<Claims> {
    private static DayThreeInput dayThreeInput;

    public DayThreeInput() {
        super(3);
    }

    public static DayThreeInput get() {
        if (dayThreeInput == null) {
            dayThreeInput = new DayThreeInput();
        }

        return dayThreeInput;
    }

    @Override
    protected Claims loadInput(Reader reader) throws IOException {
        Claims claims = new Claims();
        Node<Claim> head = null;
        Node<Claim> node = null;

        String line;
        while ((line = reader.nextLine()) != null) {
            Claim claim = getClaimFromInstruction(line);
            claims.UniqueClaims.put(claim.ID, claim);
            if (head == null) {
                head = new Node(claim);
                node = head;
            } else {
                node.Next = new Node(claim);
                node = node.Next;
            }
        }

        claims.head = head;
        return claims;
    }

    private Claim getClaimFromInstruction(String instruction) {
        Claim claim = new Claim();
        String[] instructions = instruction.split(" ");
        String[] widthHeight = instructions[2].split(",");
        String[] xy = instructions[3].split("x");

        claim.ID = instructions[0];
        claim.Row = Integer.parseInt(widthHeight[0]);
        claim.Col = Integer.parseInt(widthHeight[1].split(":")[0]);

        claim.Width = Integer.parseInt(xy[0]);
        claim.Height = Integer.parseInt(xy[1]);

        return claim;
    }
}
