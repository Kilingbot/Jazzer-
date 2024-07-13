
import chess.Move;
import chess.Situation;
import chess.variant.Standard$;
import com.pholser.junit.quickcheck.generator.InRange;
import com.pholser.junit.quickcheck.generator.Size;
import edu.berkeley.cs.jqf.fuzz.Fuzz;
import edu.berkeley.cs.jqf.fuzz.JQF;
import org.junit.runner.RunWith;
import scala.collection.IndexedSeq;

/**
 * @author Rohan Padhye
 */
@RunWith(JQF.class)
public class MoveTest {

    private Situation initial = Situation.apply(Standard$.MODULE$);

    @Fuzz
    public void tryMoves(@InRange(minInt=0) int @Size(min=1, max=20)[] choices) {
        Situation state = initial;
        Move lastMove = null;
        for (int i = 0; i < choices.length; i++) {
            IndexedSeq<Move> moves = state.moves().values().flatten((x) -> x).toIndexedSeq();
            int k = choices[i] % moves.size();
            lastMove = moves.apply(k);
            state = lastMove.situationAfter();
            //System.out.print(Dumper.apply(lastMove));
            //System.out.print(" ");
        }
        //System.out.println();
    }

}
