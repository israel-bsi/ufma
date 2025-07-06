namespace GeneticAlgorithm;

public class Individual
{
    public int[] Genes { get; private init; } //representa o indice do ap atribuido ao cliente
    public double Fitness { get; private set; } //soma das distâncias dos clientes aos seus APs + penalidade por exceder a capacidade
    private int NumAPs { get; }
    public Individual(int numberOfCustomers, int numAPs, Random random)
    {
        NumAPs = numAPs;
        Genes = new int[numberOfCustomers];
        // Atribuição aleatória inicial: cada cliente recebe um AP aleatório
        for (var i = 0; i < numberOfCustomers; i++) 
            Genes[i] = random.Next(numAPs);
    }

    // calcula o fitness da solução
    public void EvaluateFitness(List<Customer> customers, List<AccessPoint> aps)
    {
        var totalDistance = 0.0;
        var countAP = new int[aps.Count];

        for (var i = 0; i < Genes.Length; i++)
        {
            var apIndex = Genes[i];
            countAP[apIndex]++;
            double dx = customers[i].X - aps[apIndex].X;
            double dy = customers[i].Y - aps[apIndex].Y;
            totalDistance += Math.Sqrt(dx * dx + dy * dy);
        }

        // penaliza se algum AP exceder sua capacidade
        var penalty = 0.0;
        for (var i = 0; i < aps.Count; i++)
        {
            if (countAP[i] > aps[i].Capacity) 
                penalty += (countAP[i] - aps[i].Capacity) * 1000; // penalidade de 1000 para cada cliente excedente
        }
        Fitness = totalDistance + penalty;
    }

    // crossover de um ponto: combina genes dos pais
    public static Individual Crossover(Individual parent1, Individual parent2, Random random)
    {
        var length = parent1.Genes.Length;
        var offspring = new Individual(length, parent1.NumAPs, random);
        var crossoverPoint = random.Next(length);
        // o filho herda a primeira parte dos genes de um pai e a segunda parte do outro.
        for (var i = 0; i < length; i++) 
            offspring.Genes[i] = i < crossoverPoint ? parent1.Genes[i] : parent2.Genes[i];

        return offspring;
    }

    // mutação: com uma determinada taxa, altera o AP atribuído a um cliente
    public void Mutate(double mutationRate, Random random)
    {
        for (var i = 0; i < Genes.Length; i++)
        {
            if (random.NextDouble() < mutationRate) 
                Genes[i] = random.Next(NumAPs);
        }
    }

    // cria uma cópia do indivíduo
    public Individual Clone()
    {
        var clone = new Individual(Genes.Length, NumAPs, new Random())
        {
            Genes = (int[])Genes.Clone(),
            Fitness = Fitness
        };
        return clone;
    }
}