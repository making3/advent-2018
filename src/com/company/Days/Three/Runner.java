package com.company.Days.Three;

import com.company.AdventRun;
import com.company.Node;

import java.util.HashMap;
import java.util.Map;

public class Runner implements AdventRun<Claims> {
    @Override
    public String getRunName() {
        return "Part 1";
    }

    @Override
    public Claims getInput() {
        return DayThreeInput.get().getInput();
    }

    @Override
    public String run(Claims claims) {
        int overlappingClaims = 0;
        String[][] coords = new String[1000][1000];
        Node<Claim> node = claims.head;

        do {
            overlappingClaims += mapClaims(claims.UniqueClaims, node.Value, coords);
        } while ((node = node.Next) != null);

        Map.Entry<String,Claim> entry = claims.UniqueClaims.entrySet().iterator().next();
        Claim singleClaim = entry.getValue();
        return overlappingClaims + "; Part 2 - " + singleClaim.ID;
    }

    // This is totally sloppy, yes
    private String CLAIMED="claimed";

    private int mapClaims(HashMap<String, Claim> uniqueClaims, Claim claim, String[][] coords) {
        int overlappingClaims = 0;

        for (int i = 0; i < claim.Height; i++) {
            for (int k = 0; k < claim.Width; k++) {
                int row = i+claim.Col;
                int col = k+claim.Row;

                if (coords[row][col] == null) {
                    coords[row][col] = claim.ID;
                } else if (coords[row][col] == CLAIMED) {
                    uniqueClaims.remove(claim.ID);
                } else {
                    overlappingClaims++;
                    uniqueClaims.remove(claim.ID);
                    uniqueClaims.remove(coords[row][col]);
                    coords[row][col] = CLAIMED;
                }
            }
        }

        return overlappingClaims;
    }
}
