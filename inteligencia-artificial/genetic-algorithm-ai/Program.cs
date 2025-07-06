namespace GeneticAlgorithm;

public class Program
{
    public static void Main(string[] args)
    {
        var aps = new List<AccessPoint>
        {
            new("A", 0, 0, 64),
            new("B", 80, 0, 64),
            new("C", 0, 80, 128),
            new("D", 80, 80, 128)
        };

        var csvFile = Path.Combine(Directory.GetCurrentDirectory(), "ag_data.csv");
        var customers = ReadClientsFromCsv(csvFile);
        Console.WriteLine($"Total de clientes carregados: {customers.Count}");

        // parâmetros do algoritmo genético
        const int PopulationSize = 50;
        const int Generations = 500;
        const double MutationRate = 0.1;

        var random = new Random();
        var population = new List<Individual>();

        // inicializa a população com indivíduos aleatórios
        for (var i = 0; i < PopulationSize; i++)
        {
            var ind = new Individual(customers.Count, aps.Count, random);
            ind.EvaluateFitness(customers, aps);
            population.Add(ind);
        }

        // seleciona o melhor indivíduo inicial
        var best = population.OrderBy(ind => ind.Fitness).First();

        // loop principal do algoritmo genético com elitismo e seleção por torneio
        for (var gen = 0; gen < Generations; gen++)
        {
            // elitismo: preserva o melhor indivíduo
            var newPopulation = new List<Individual> { best.Clone() };

            // gera novos indivíduos utilizando seleção por torneio torneio até completar a população
            while (newPopulation.Count < PopulationSize)
            {
                var parent1 = TournamentSelection(population, random);
                var parent2 = TournamentSelection(population, random);
                var offspring = Individual.Crossover(parent1, parent2, random);
                offspring.Mutate(MutationRate, random);
                offspring.EvaluateFitness(customers, aps);
                newPopulation.Add(offspring);
            }
            population = newPopulation;

            // atualiza o melhor indivíduo
            var currentBest = population.OrderBy(ind => ind.Fitness).First();
            if (currentBest.Fitness < best.Fitness) 
                best = currentBest.Clone();

            // exibe o melhor fitness a cada 50 gerações
            if (gen % 50 == 0) 
                Console.WriteLine($"Geração {gen}, melhor fitness: {best.Fitness:F2}");
        }

        Console.WriteLine("\nAtribuição final dos clientes aos APs:");
        for (var i = 0; i < best.Genes.Length; i++)
        {
            var customer = customers[i];
            var ap = aps[best.Genes[i]];
            Console.WriteLine($"Cliente ({customer.X}, {customer.Y}) => AP {ap.Name} ({ap.X}, {ap.Y})");
        } 
        
        Console.WriteLine("\nFitness final: " + best.Fitness.ToString("F2"));
        Console.WriteLine("Clientes no AP 1: " + best.Genes.Count(g => g == 0));
        Console.WriteLine("Clientes no AP 2: " + best.Genes.Count(g => g == 1));
        Console.WriteLine("Clientes no AP 3: " + best.Genes.Count(g => g == 2));
        Console.WriteLine("Clientes no AP 4: " + best.Genes.Count(g => g == 3));
    }

    // seleção por torneio: seleciona o melhor entre um subconjunto aleatório da população
    private static Individual TournamentSelection(List<Individual> population, Random random, int tournamentSize = 3)
    {
        var tournament = new List<Individual>();
        for (var i = 0; i < tournamentSize; i++)
        {
            var idx = random.Next(population.Count);
            tournament.Add(population[idx]);
        }
        return tournament.OrderBy(ind => ind.Fitness).First();
    }

    private static List<Customer> ReadClientsFromCsv(string filePath)
    {
        var customers = new List<Customer>();
        var lines = File.ReadAllLines(filePath);

        for (var i = 1; i < lines.Length; i++)
        {
            var line = lines[i];
            var split = line.Split([';', '\t'], StringSplitOptions.RemoveEmptyEntries);
            var x = int.Parse(split[1]);
            var y = int.Parse(split[2]);
            customers.Add(new Customer(x, y));
        }
        return customers;
    }
}